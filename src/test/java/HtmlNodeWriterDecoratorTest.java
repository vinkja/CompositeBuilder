import com.mscharhag.oleaster.runner.OleasterRunner;
import org.junit.runner.RunWith;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

@RunWith(OleasterRunner.class)
public class HtmlNodeWriterDecoratorTest {{

  describe("Line numbers with indent", () -> {

    it("should number indented lines", () -> {
      AttributedCompositeNode root = AttributedCompositeNode.create("html");
      AttributedCompositeNode child1 = HtmlNodeFactory.createA("about:blank");
      AttributedCompositeNode child2 = HtmlNodeFactory.createA("about:blank");
      root
              .addChild(child1)
              .addChild(child2);

      String html = LineNumberHtmlNodeWriter.create(IndentHtmlNodeWriter.create(0, HtmlNodeWriter.create())).write(root);

      expect(html).toEqual("1 <html>\n2  <a href='about:blank'></a>\n3  <a href='about:blank'></a>\n4 </html>");
    });
  });
}}