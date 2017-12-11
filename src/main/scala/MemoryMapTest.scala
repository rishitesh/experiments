import java.io.RandomAccessFile
import java.nio.channels.FileChannel

/**
  * Created by rishim on 8/12/17.
  */
object MemoryMapTest extends App {
  val length = 0x8FFFFFF; // 128 Mb

  val out = new RandomAccessFile("howtodoinjava.dat", "rw")
      .getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);


  (0 to length).map(i => {
    out.put('x'.asInstanceOf[Byte]);
  })

  println("Finished writing");
}
