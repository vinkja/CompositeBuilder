import com.mscharhag.oleaster.runner.OleasterRunner;
import org.junit.runner.RunWith;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

@RunWith(OleasterRunner.class)
public class CapitalizedTagHtmlNodeWriterTest {{

  describe("Any nesting level", () -> {

    it("should write all tags in upper case", () -> {
      AttributedCompositeNode root = AttributedCompositeNode.create("html");
      AttributedCompositeNode child1 = HtmlNodeFactory.createA("about:blank");
      AttributedCompositeNode child2 = HtmlNodeFactory.createSpan();
      root
              .addChild(child1)
              .addChild(child2);

      String html = CapitalizedTagHtmlNodeWriter.create().write(root);

      expect(html).toEqual("<HTML><A href='about:blank'></A><SPAN></SPAN></HTML>");
    });
  });
}}