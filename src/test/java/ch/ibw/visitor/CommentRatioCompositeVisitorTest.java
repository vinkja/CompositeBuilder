package ch.ibw.visitor;

import ch.ibw.AttributedCompositeNode;
import ch.ibw.CommentNode;
import ch.ibw.HtmlNode;
import ch.ibw.HtmlNodeFactory;
import ch.ibw.visitor.CommentRatioCompositeVisitor;
import com.mscharhag.oleaster.runner.OleasterRunner;
import org.junit.runner.RunWith;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

@RunWith(OleasterRunner.class)
public class CommentRatioCompositeVisitorTest {{

  describe("getPercentageOfComments", () -> {
    it("should be zero if no comments", () -> {
      CommentRatioCompositeVisitor visitor = new CommentRatioCompositeVisitor();

      HtmlNode node = (HtmlNode) HtmlNode.create("root")
              .addChild(HtmlNode.create("span")
                      .addChild(HtmlNode.create("div")));

      node.accept(visitor);

      expect(visitor.getPercentageOfComments()).toEqual(0.0);
    });

    it("should be 100 if only comments", () -> {
      CommentRatioCompositeVisitor visitor = new CommentRatioCompositeVisitor();

      CommentNode node = CommentNode.create("my comment");

      node.accept(visitor);

      expect(visitor.getPercentageOfComments()).toEqual(100.0);
    });

    it("should be 50 if even", () -> {
      CommentRatioCompositeVisitor visitor = new CommentRatioCompositeVisitor();

      AttributedCompositeNode node = CommentNode.create("my comment").addChild(HtmlNodeFactory.createSpan());

      visitor.acceptAll(node);

      expect(visitor.getPercentageOfComments()).toEqual(50.0);
    });
  });
}}