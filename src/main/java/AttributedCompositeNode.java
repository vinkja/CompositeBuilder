import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
    return new AttributedCompositeNode(name.trim());
  }

  public AttributedCompositeNode setAttribute(String key, String value) {
    attributes.put(key, value);
    return this;
  }

  public Boolean isLastChild(){
    if(parent == null){
      return true;
    }
    return parent.children.get(parent.children.size()-1).equals(this);
  }

  public AttributedCompositeNode addChild(AttributedCompositeNode child) {
    children.add(child);
    child.parent = this;
    return this;
  }
}
