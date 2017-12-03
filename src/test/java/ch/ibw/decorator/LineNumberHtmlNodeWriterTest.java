package ch.ibw.decorator;

import ch.ibw.HtmlNode;
import ch.ibw.HtmlNodeFactory;
import com.mscharhag.oleaster.runner.OleasterRunner;
import org.junit.runner.RunWith;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

@RunWith(OleasterRunner.class)
public class LineNumberHtmlNodeWriterTest {{

  describe("Any nesting level", () -> {

    it("should number single line", () -> {
      HtmlNode root = HtmlNode.create("html");
      HtmlNode child1 = HtmlNodeFactory.createA("about:blank");
      HtmlNode child2 = HtmlNodeFactory.createA("about:blank");
      root
              .addChild(child1)
              .addChild(child2);

      String html = LineNumberHtmlNodeWriter.create().write(root);

      expect(html).toEqual("1 <html><a href='about:blank'></a><a href='about:blank'></a></html>");
    });
  });
}}