package gg.jte.generated.ondemand.courses;
import org.example.hexlet.dto.courses.CoursesPage;
public final class JteindexGenerated {
	public static final String JTE_NAME = "courses/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,1,1,9,9,9,10,10,10,11,11,11,12,12,15,15,15,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, CoursesPage page) {
		jteOutput.writeContent("\n<html lang=\"en\">\n    <head>\n        <title>Хекслет</title>\n    </head>\n    <body>\n        <main>\n            ");
		for (var course: page.getCourses()) {
			jteOutput.writeContent("\n                <h1>");
			jteOutput.setContext("h1", null);
			jteOutput.writeUserContent(course.getName());
			jteOutput.writeContent("</h1>\n                <p>");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(course.getDescription());
			jteOutput.writeContent("</p>\n            ");
		}
		jteOutput.writeContent("\n        </main>\n    </body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		CoursesPage page = (CoursesPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
