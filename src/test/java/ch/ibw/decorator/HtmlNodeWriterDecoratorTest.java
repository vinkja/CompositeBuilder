package ch.ibw.decorator;

import ch.ibw.CapitalizedTagHtmlNodeWriter;
import ch.ibw.HtmlNode;
import ch.ibw.HtmlNodeFactory;
import com.mscharhag.oleaster.runner.OleasterRunner;
import org.junit.runner.RunWith;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

@RunWith(OleasterRunner.class)
public class HtmlNodeWriterDecoratorTest {{

  describe("Decorator Combinations", () -> {

    it("should number indented lines and capitalize tag names", () -> {
      HtmlNode root = HtmlNode.create("html");
      HtmlNode link1 = HtmlNodeFactory.createA("about:blank1");
      HtmlNode link2 = HtmlNodeFactory.createA("about:blank2");
      HtmlNode span = HtmlNodeFactory.createSpan();

      root
              .addChild(link1
                      .addChild(span))
              .addChild(link2);

      String html = LineNumberHtmlNodeWriter.create(
                      IndentHtmlNodeWriter.create(0,
                              CapitalizedTagHtmlNodeWriter.create())).write(root);
      System.out.println(html);
      expect(html).toEqual("1 <HTML>\n" +
                                 "2  <A href='about:blank1'>\n" +
                                 "3   <SPAN></SPAN>\n" +
                                 "4  </A>\n" +
                                 "5  <A href='about:blank2'></A>\n" +
                                 "6 </HTML>");
    });
  });
}}