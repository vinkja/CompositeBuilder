import com.mscharhag.oleaster.runner.OleasterRunner;
import org.junit.runner.RunWith;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

@RunWith(OleasterRunner.class)
public class AttributedCompositeNodeTest {{
  describe("No Attributes", () -> {
    it("should be possible to create a node without attributes but a name", () -> {
     AttributedCompositeNode node = AttributedCompositeNode.create("node");
     expect(node.name).toEqual("node");
    });
  });

  describe("With Attributes", () -> {
    it("should be possible to set multiple attributes (key, values)", () -> {
      AttributedCompositeNode node = AttributedCompositeNode.create("node");
      node.setAttribute("key", "value");
      node.setAttribute("key1", "value1");
      expect(node.attributes.size()).toEqual(2);
    });

    it("should overwrite existing keys", () -> {
      AttributedCompositeNode node = AttributedCompositeNode.create("node");
      node.setAttribute("key", "value");
      node.setAttribute("key", "value1");
      expect(node.attributes.get("key")).toEqual("value1");
    });
  });

  describe("Composition", () -> {
    it("should have access to added children", () -> {
      AttributedCompositeNode node = AttributedCompositeNode.create("node");
      node.addChild(node);
      expect(node.children.size()).toEqual(1);
    });

    describe("Child", () -> {
      it("should have access to parent", () -> {
        AttributedCompositeNode node = AttributedCompositeNode.create("node");
        node.addChild(node);
        expect(node.parent).toEqual(node);
      });
    });
  });
}}