import java.util.*;

public class AttributedCompositeNode {
  public String name;
  public Map<String, Object> attributes;
  public List<AttributedCompositeNode> children;
  public AttributedCompositeNode parent;

  private AttributedCompositeNode(String name) {
    this.name = name;
    this.attributes = new LinkedHashMap<>();
    this.children = new ArrayList<>();
  }

  public static AttributedCompositeNode create(String name) {
    return new AttributedCompositeNode(name);
  }

  public AttributedCompositeNode setAttribute(String key, String value) {
    attributes.put(key, value);
    return this;
  }

  public void addChild(AttributedCompositeNode child) {
    children.add(child);
    child.parent = this;
  }
}
