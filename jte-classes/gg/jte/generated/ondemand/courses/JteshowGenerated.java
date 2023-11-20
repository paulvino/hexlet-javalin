package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursePage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "courses/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,9,9,9,9,10,10,10,13,13,13,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursePage page) {
		jteOutput.writeContent("\n<html lang=\"en\">\n    <head>\n        <title>Хекслет</title>\n    </head>\n    <body>\n        <main>\n            <h1>");
		jteOutput.setContext("h1", null);
		jteOutput.writeUserContent(page.getCourse().getName());
		jteOutput.writeContent("</h1>\n            <p>");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(page.getCourse().getDescription());
		jteOutput.writeContent("</p>\n        </main>\n    </body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursePage page = (CoursePage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
