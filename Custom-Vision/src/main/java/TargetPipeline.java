import edu.wpi.first.vision.VisionPipeline;
import java.util.*;
import org.opencv.core.*;
import org.opencv.imgproc.*;

public class TargetPipeline implements VisionPipeline {

    public volatile Mat result;

    @Override
    public void process(Mat mat) {

        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGB2GRAY);

        Imgproc.blur(mat, mat, new Size(3, 3));

        Imgproc.threshold(mat, mat, 235, 255, 0);

        Imgproc.Canny(mat, mat, 50, 200, 3, false);

        List<MatOfPoint> contours = new ArrayList<>();
        Mat hierarchy = new Mat();

        Imgproc.findContours(mat, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_NONE);

        MatOfPoint2f[] contoursPoly = new MatOfPoint2f[contours.size()];
        Rect boundRects[] = new Rect[contours.size()];

        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_GRAY2BGR);

        for (int i = 0; i < contours.size(); i++) {
            contoursPoly[i] = new MatOfPoint2f();
            Imgproc.approxPolyDP(new MatOfPoint2f(contours.get(i).toArray()), contoursPoly[i], 3, true);
            boundRects[i] = Imgproc.boundingRect(contoursPoly[i]);
        }

        if (boundRects.length > 0) {

            ArrayList<Rect> targets = new ArrayList<>();
            for (int i = 0; i < boundRects.length; i++) {
                double contourArea = Imgproc.contourArea(contours.get(i));
                double rectArea = boundRects[i].area();
                if (contourArea / rectArea < 1.00 && contourArea / rectArea > .65) {
                    targets.add(boundRects[i]);
                }
            }

            ArrayList<ArrayList<Rect>> groups = new ArrayList<>();
            int currIndex = 0;
            for (Rect r : targets) {
                if (groups.isEmpty()) {
                    groups.add(new ArrayList<>());
                    groups.get(currIndex).add(r);
                    currIndex++;
                    continue;
                }
                boolean match = false;
                for (int i = 0; i < groups.size(); i++) {
                    if (Math.abs(groups.get(i).get(0).y - r.y) < 25) {
                        groups.get(i).add(r);
                        match = true;
                        break;
                    }

                }
                if (!match) {
                    groups.add(new ArrayList<>());
                    groups.get(currIndex).add(r);
                    currIndex++;
                }
            }

            int maxIndex = 0;
            for (int i = 0; i < groups.size(); i++) {
                if (groups.get(i).size() > groups.get(maxIndex).size()) {
                    maxIndex = i;
                }
            }
            if(!groups.isEmpty()) targets = groups.get(maxIndex);
            for (Rect r : targets) {
                Imgproc.rectangle(mat, r.tl(), r.br(), new Scalar(0, 0, 255));
            }
            
            // calculate the center of the cluster as the target
            int totalArea = 0;
            int totalProductX = 0;
            int totalProductY = 0;
            for(Rect r : targets) {
                // first, find the x midpoint of the rectangle
                if(r.width == 0 || r.height == 0) continue;
                int midX = r.x + (r.width / 2);
                int midY = r.y + (r.height / 2);
                totalProductX += midX * r.area();
                totalProductY += midY * r.area();
                totalArea += r.area();
            }

            if(totalArea > 0) {
                int targetX = totalProductX / totalArea;
                int targetY = totalProductY / totalArea;

                Imgproc.line(mat, new Point(targetX, targetY - 20), new Point(targetX, targetY + 20), new Scalar(0, 255, 0));
                Imgproc.line(mat, new Point(targetX - 20, targetY), new Point(targetX + 20, targetY), new Scalar(0, 255, 0));
            }

        }
        result = mat.clone();
    }
}
