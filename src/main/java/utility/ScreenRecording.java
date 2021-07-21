package utility;

import org.monte.media.Format;
import org.monte.media.Registry;
import org.monte.media.math.Rational;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;
import org.monte.screenrecorder.ScreenRecorder;

public class ScreenRecording extends ScreenRecorder {

    /***
     * ScreenRecording class is used to record the video of test cases while executing
     * createMovieFile method is used for creating the folder with methode name
     * startRecord and stopRecord methods are used to start the recording and stop recording.
     */


    public static ScreenRecorder screenRecorder;
    public String name;

    public ScreenRecording(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat,
                           Format screenFormat,Format mouseFormat, Format audioFormat, File movieFolder,
                           String name) throws IOException, AWTException{
        super(cfg,captureArea,fileFormat,screenFormat,mouseFormat,audioFormat,movieFolder);
        this.name = name;
    }

    @Override
    protected File createMovieFile(Format fileFormat){
        try {

            if (!movieFolder.exists()) {
                movieFolder.mkdirs();
            } else if (!movieFolder.isDirectory()) {
                throw new IOException("\"" + movieFolder + "\" is not a directory.");
            }

        }catch (IOException e) {
                e.printStackTrace();
            }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        return new File(movieFolder, name + "-" + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));
    }

    public static void startRecord(String methodName){
        File file = new File("./test-recordings/");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        Rectangle captureSize = new Rectangle(0,0,width, height);

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        try {
            screenRecorder = new ScreenRecording(gc ,captureSize, new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                    new Format(MediaTypeKey,MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24 , FrameRateKey,
                            Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                    null, file,methodName);
            screenRecorder.start();

        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }
    }

    public static void stopRecord(){
        try {
            screenRecorder.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
