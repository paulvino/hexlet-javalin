package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,16,16,16,16,17,17,17,18,18,18,21,21,21,1,2,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, Content footer, Content header) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n    <head>\n        <meta charset=\"utf-8\" />\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n        <title>Hexlet Javalin Example</title>\n    </head>\n    <body>\n        <p>\n            <h1><a href=\"/\">Main</a> <a href=\"/courses\">Courses</a></h1>\n        </p>\n        ");
		jteOutput.setContext("body", null);
		jteOutput.writeUserContent(header);
		jteOutput.writeContent("\n        ");
		jteOutput.setContext("body", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n        ");
		jteOutput.setContext("body", null);
		jteOutput.writeUserContent(footer);
		jteOutput.writeContent("\n    </body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		Content footer = (Content)params.getOrDefault("footer", null);
		Content header = (Content)params.getOrDefault("header", null);
		render(jteOutput, jteHtmlInterceptor, content, footer, header);
	}
}
