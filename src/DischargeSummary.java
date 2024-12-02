public class DischargeSummary {
    private String id;
    private String patientName;
    private String diagnosis;
    private String treatment;
    private String dischargeDate;

    public DischargeSummary(String id, String patientName, String diagnosis, String treatment, String dischargeDate) {
        this.id = id;
        this.patientName = patientName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.dischargeDate = dischargeDate;
    }

    public String getId() {
        return id;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    @Override
    public String toString() {
        return "DischargeSummary{" +
                "id='" + id + '\'' +
                ", patientName='" + patientName + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", treatment='" + treatment + '\'' +
                ", dischargeDate=" + dischargeDate +
                '}';
    }
}