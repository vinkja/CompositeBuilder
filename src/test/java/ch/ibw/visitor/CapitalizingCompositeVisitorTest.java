package ch.ibw.visitor;

import ch.ibw.HtmlNode;
import ch.ibw.visitor.CapitalizingCompositeVisitor;
import com.mscharhag.oleaster.runner.OleasterRunner;
import org.junit.runner.RunWith;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

@RunWith(OleasterRunner.class)
public class CapitalizingCompositeVisitorTest {{

  describe("HtmlNode", () -> {
    it("should convert all node names to uppercase", () -> {
      CapitalizingCompositeVisitor visitor = new CapitalizingCompositeVisitor();

      HtmlNode node = (HtmlNode) HtmlNode.create("root")
              .addChild(HtmlNode.create("span")
                      .addChild(HtmlNode.create("div")));

      visitor.acceptAll(node);

      expect(node.name).toEqual("ROOT");
      expect(((HtmlNode)node.children.get(0)).name).toEqual("SPAN");
      expect(((HtmlNode)node.children.get(0).children.get(0)).name).toEqual("DIV");
    });
  });
}}