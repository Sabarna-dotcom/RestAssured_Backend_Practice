import io.restassured.path.json.JsonPath;
import org.example.file.ReUsableMethods;
import org.example.file.payload;

public class ComplexJsonParse {

    public static void main(String[] args) {
        // Print the number of courses returned by API
        JsonPath js = ReUsableMethods.rawToJson(payload.CoursePrice());
        int count = js.getInt("courses.size()");
        System.out.println(count);

        // Print purchase amount
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);

        // Print title of the first course
        String firstCourseTitle = js.getString("courses[0].title");
        System.out.println(firstCourseTitle);

        // Print all course titles and their respective prices
        for (int i = 0; i < count; i++) {
            String courseTitle = js.getString("courses[" + i + "].title");
            int coursePrice = js.getInt("courses[" + i + "].price");
            System.out.println(courseTitle + ": " + coursePrice);
        }

        // Print number of copies sold by RPA Course
        for (int i = 0; i < count; i++) {
            String courseTitle = js.getString("courses[" + i + "].title");
            if (courseTitle.equalsIgnoreCase("RPA")) {
                int copiesSold = js.getInt("courses[" + i + "].copies");
                System.out.println("Copies sold by RPA Course: " + copiesSold);
                break;
            }
        }
    }
}
