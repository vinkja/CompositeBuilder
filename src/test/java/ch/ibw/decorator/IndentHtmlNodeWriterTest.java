package ch.ibw.decorator;

import ch.ibw.HtmlNode;
import ch.ibw.HtmlNodeFactory;
import com.mscharhag.oleaster.runner.OleasterRunner;
import org.junit.runner.RunWith;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

@RunWith(OleasterRunner.class)
public class IndentHtmlNodeWriterTest {{

  describe("One Nested Level", () -> {
    it("should indent with one space", () -> {
      HtmlNode root = HtmlNode.create("html");
      HtmlNode child1 = HtmlNodeFactory.createA("about:blank");
      HtmlNode child2 = HtmlNodeFactory.createA("about:blank");
      root
        .addChild(child1)
        .addChild(child2);

      String html = IndentHtmlNodeWriter.create(0).write(root);

      expect(html).toEqual("<html>\n <a href='about:blank'></a>\n <a href='about:blank'></a>\n</html>\n");
    });
  });
}}