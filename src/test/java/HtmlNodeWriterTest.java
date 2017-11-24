import com.mscharhag.oleaster.runner.OleasterRunner;
import org.junit.runner.RunWith;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

@RunWith(OleasterRunner.class)
public class HtmlNodeWriterTest {{

  describe("Composition", () -> {
    it("should be possible to create one level nested html", () -> {
      AttributedCompositeNode root = AttributedCompositeNode.create("html");

      root.addChild(HtmlNodeFactory.createA("about:blank"));
      String html = HtmlNodeWriter.create().write(root);

      expect(html).toEqual("<html><a href='about:blank'></a></html>");
    });

    it("should be possible to create two level nested html", () -> {
      AttributedCompositeNode root = AttributedCompositeNode.create("html");
      AttributedCompositeNode a1 = HtmlNodeFactory.createA("about:blank1");
      AttributedCompositeNode a2 = HtmlNodeFactory.createA("about:blank2");
      AttributedCompositeNode nestedSpan = AttributedCompositeNode.create("span");

      root
              .addChild(a1
                      .addChild(nestedSpan))
              .addChild(a2);

      String html = HtmlNodeWriter.create().write(root);

      expect(html).toEqual(
              "<html>" +
                "<a href='about:blank1'>" +
                "<span></span>" +
                "</a>" +
                "<a href='about:blank2'></a>" +
              "</html>");
    });
  });
}}