package edu.usc.lunchnlearn.springmvc.tags;

import edu.usc.lunchnlearn.springmvc.bean.Crumb;

import java.util.Map;

/**
 * EL Custom tag class that handles breadcrumbs.
 */
public class Breadcrumbler {

    private Breadcrumbler() {
        //hide the constructor since static class.
    }

    /**
     * EL Custom tag that goes into the head.  Puts the proper values into the HTML HEAD tag.
     * @param pathToJSFiles     Path to directory of JavaScript files.
     * @param pathToCSSFiles    Path to directory of CSS files.
     * @return                  Returns a string that gets put onto the JSP page.
     */
    public static String breadCrumbHead(String pathToJSFiles, String pathToCSSFiles) {
        StringBuilder sb = new StringBuilder();

        sb.append("<script type=\"text/javascript\" src=\"").append(pathToJSFiles).append("jquery.easing.1.3.js\"></script>\n");
        sb.append("<script type=\"text/javascript\" src=\"").append(pathToJSFiles).append("jquery.jBreadCrumb.1.1.js\"></script>\n");

        sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"").append(pathToCSSFiles).append("BreadCrumb.css\" />\n");

        sb.append("<script type=\"text/javascript\">\n");
        sb.append("    $(document).ready(function() {\n");
        sb.append("          $(\"#breadCrumb\").jBreadCrumb({easing:'easeOutQuad'});\n");
        sb.append("    })\n");
        sb.append("</script>\n");

        return sb.toString();
    }

    private static String getBreadCrumbs(boolean isLast, Long currentX, Map<Long, Crumb> breadCrumbs) {
        StringBuilder sb = new StringBuilder();

        if(breadCrumbs.containsKey(currentX)) {
            Crumb currentCrumb = breadCrumbs.get(currentX);

            if(currentCrumb.getParentX() != 0L) {
                sb.append(getBreadCrumbs(false, currentCrumb.getParentX(), breadCrumbs));
            }

            int size = sb.length();

            sb.append("<li>");

            //The last crumb shouldn't have an anchor tag unless it is the only crumb in the
            //list - this is because the CSS for the home image only works on anchor tags.
            if(!isLast || size == 0) {
                sb.append("<a href='").append(currentCrumb.getUrl()).append("'>");
            }

            sb.append(currentCrumb.getDisplayText());

            if(!isLast || size == 0) {
                sb.append("</a>");
            }

            sb.append("\n</li>\n");
        }

        return sb.toString();
    }


    /**
     * EL Custom tag that goes into the body.  Puts the breadcrumbs on the page.
     * @param currentX          The current breadcrumb key.
     * @param breadCrumbs       The map of breadcrumbs.
     * @return                  Returns a string that gets put onto the JSP page.
     */
    public static String breadCrumbBody(Long currentX, Map<Long, Crumb> breadCrumbs) {
        StringBuilder sb = new StringBuilder();

        sb.append("<div class=\"breadCrumbHolder module\">\n");
        sb.append("    <div id=\"breadCrumb\" class=\"breadCrumb module\">\n");
        sb.append("         <ul>\n");

        sb.append(getBreadCrumbs(true, currentX, breadCrumbs));

        sb.append("         </ul>\n");
        sb.append("    </div>\n");
        sb.append("</div>\n");
        sb.append("<div class=\"chevronOverlay main\">\n");
        sb.append("</div>\n");

        return sb.toString();
    }

}
