public class HtmlDocumentBuilder {
  public String doctype;
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
    if(doctype != null && doctype.trim() != ""){
      builder.append(doctype).append("\n");
    }
    if(root != null){
      builder.append(HtmlNodeWriter.write(root));
    }
    return builder.toString();
  }
}
