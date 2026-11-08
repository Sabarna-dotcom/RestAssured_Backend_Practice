import org.testng.annotations.Test;

public class SumValidation {

    @Test
    public void sumOfCourses() {
        int sum = 0;
        int expectedSum = 910; // Expected sum of all course prices

        // Get the JSON response from the payload
        String response = org.example.file.payload.CoursePrice();
        io.restassured.path.json.JsonPath js = org.example.file.ReUsableMethods.rawToJson(response);

        // Get the number of courses
        int count = js.getInt("courses.size()");

        // Calculate the sum of all course prices
        for (int i = 0; i < count; i++) {
            int coursePrice = js.getInt("courses[" + i + "].price") * js.getInt("courses[" + i + "].copies");
            sum += coursePrice;
        }

        // Validate the sum against the expected value
        assert sum == expectedSum : "Sum of course prices is incorrect. Expected: " + expectedSum + ", but got: " + sum;
    }

}
