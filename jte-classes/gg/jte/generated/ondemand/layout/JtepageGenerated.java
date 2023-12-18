package gg.jte.generated.ondemand.layout;
import gg.jte.Content;
import org.example.hexlet.util.NamedRoutes;
import org.example.hexlet.dto.BasePage;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,24,24,24,24,24,24,24,24,24,24,27,27,27,27,27,27,27,27,27,30,30,30,30,30,30,30,30,30,33,33,33,33,33,33,33,33,33,40,40,42,42,42,44,44,46,46,46,47,47,47,51,51,51,51,51,51,51,51,51,54,54,54,54,54,54,54,54,54,57,57,57,57,57,57,57,57,57,64,64,64,3,4,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, BasePage page, Content header) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n    <head>\n        <meta charset=\"utf-8\" />\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n        <link rel=\"stylesheet\"\n              href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\"\n              integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\n              crossorigin=\"anonymous\">\n        <title>Hexlet Javalin Example</title>\n    </head>\n    <body>\n        <div>\n            <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n                <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n                    <ul class=\"navbar-nav mr-auto\">\n                        <li class=\"nav-item\">\n                            <a class=\"nav-link\"");
		var __jte_html_attribute_0 = NamedRoutes.mainPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Main</a>\n                        </li>\n                        <li class=\"nav-item\">\n                            <a class=\"nav-link\"");
		var __jte_html_attribute_1 = NamedRoutes.usersPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Users</a>\n                        </li>\n                        <li class=\"nav-item\">\n                            <a class=\"nav-link\"");
		var __jte_html_attribute_2 = NamedRoutes.coursesPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_2)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_2);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Courses</a>\n                        </li>\n                        <li class=\"nav-item\">\n                            <a class=\"nav-link\"");
		var __jte_html_attribute_3 = NamedRoutes.carsPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_3)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_3);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Cars</a>\n                        </li>\n                    </ul>\n                </div>\n            </nav>\n        </div>\n        <p>\n            ");
		if (page != null && page.getFlash() != null) {
			jteOutput.writeContent("\n                <div class=\"alert alert-success\" role=\"alert\">\n                ");
			jteOutput.setContext("div", null);
			jteOutput.writeUserContent(page.getFlash());
			jteOutput.writeContent("\n                </div>\n            ");
		}
		jteOutput.writeContent("\n        </p>\n        ");
		jteOutput.setContext("body", null);
		jteOutput.writeUserContent(header);
		jteOutput.writeContent("\n        ");
		jteOutput.setContext("body", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n        <div>\n            <ul class=\"nav\">\n                <li class=\"nav-item\">\n                    <a class=\"nav-link\"");
		var __jte_html_attribute_4 = NamedRoutes.buildUserPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_4)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_4);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Add new user</a>\n                </li>\n                <li class=\"nav-item\">\n                    <a class=\"nav-link\"");
		var __jte_html_attribute_5 = NamedRoutes.buildCoursePath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_5)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_5);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Add new course</a>\n                </li>\n                <li class=\"nav-item\">\n                    <a class=\"nav-link\"");
		var __jte_html_attribute_6 = NamedRoutes.buildCarPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_6)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_6);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Add new car</a>\n                </li>\n            </ul>\n        </div>\n        <a href=\"https://github.com/paulvino/hexlet-javalin\" class=\"badge badge-info\">Project on GitHub</a>\n    </body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		BasePage page = (BasePage)params.getOrDefault("page", null);
		Content header = (Content)params.getOrDefault("header", null);
		render(jteOutput, jteHtmlInterceptor, content, page, header);
	}
}
