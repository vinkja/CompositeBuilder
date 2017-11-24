import java.util.Objects;

public class HtmlDocumentBuilder {
  private String doctype;
  private AttributedCompositeNode root;

  public HtmlDocumentBuilder(String doctype) {
    this.doctype = doctype;
  }

  public static HtmlDocumentBuilder create(String doctype) {
    return new HtmlDocumentBuilder(doctype);
  }

  public void setRoot(AttributedCompositeNode root) {
    this.root = root;
  }

  public String generateHtml() {
    StringBuilder builder = new StringBuilder();
    if(doctype != null && !Objects.equals(doctype.trim(), "")){
      builder.append(doctype).append("\n");
    }
    if(root != null){
      builder.append(HtmlNodeWriter.create().write(root));
    }
    return builder.toString();
  }
}
