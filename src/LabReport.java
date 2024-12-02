public class LabReport {
    private String id;
    private String patientName;
    private String testName;
    private String result;
    private String date;

    public LabReport(String id, String patientName, String testName, String result, String date) {
        this.id = id;
        this.patientName = patientName;
        this.testName = testName;
        this.result = result;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getTestName() {
        return testName;
    }

    public String getResult() {
        return result;
    }

    public String getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "LabReport{" +
                "id='" + id + '\'' +
                ", patientName='" + patientName + '\'' +
                ", testName='" + testName + '\'' +
                ", result='" + result + '\'' +
                ", date=" + date +
                '}';
    }
}