package bokoff.il;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SkippedTests {

  @Test
  @Disabled
  void test00(){
    assertTrue(false);
  }

  @Test
  @Disabled
  void test01(){
    assertTrue(false);
  }

  @Test
  @Disabled("some reason")
  void test02(){
    assertTrue(false);
  }


}
