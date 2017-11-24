import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttributedCompositeNode {
  public String name;
  public Map<String, Object> attributes;
  public List<AttributedCompositeNode> children;
  public AttributedCompositeNode parent;

  private AttributedCompositeNode(String name) {
    this.name = name;
    this.attributes = new HashMap<>();
    this.children = new ArrayList<>();
  }

  public static AttributedCompositeNode create(String name) {
    return new AttributedCompositeNode(name);
  }

  public void setAttribute(String key, String value) {
    attributes.put(key, value);
  }

  public void addChild(AttributedCompositeNode child) {
    children.add(child);
    child.parent = this;
  }
}
