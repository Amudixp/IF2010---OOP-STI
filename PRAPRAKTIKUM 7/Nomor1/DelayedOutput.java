/**
 * DelayedOutput.java 
 * [Jelaskan kegunaan class ini]
 * @author [18223049] [Amudi Purba]
 */
public class DelayedOutput {
    public static void printDelayed(int delayMillisec, String output) {
        // TODO print output setelah di delay selama delayMillisec
        // PENTING: gunakan threading agar tidak blocking
        new Thread(() ->{
            try {
                Thread.sleep(delayMillisec);
                System.out.println(output);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
  }

  