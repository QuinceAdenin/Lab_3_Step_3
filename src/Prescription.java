public class Prescription {
    private String id;
    private String patientName;
    private String medication;
    private String dosage;
    private String date;

    public Prescription(String id, String patientName, String medication, String dosage, String date) {
        this.id = id;
        this.patientName = patientName;
        this.medication = medication;
        this.dosage = dosage;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getMedication() {
        return medication;
    }

    public String getDosage() {
        return dosage;
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

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id='" + id + '\'' +
                ", patientName='" + patientName + '\'' +
                ", medication='" + medication + '\'' +
                ", dosage='" + dosage + '\'' +
                ", date=" + date +
                '}';
    }
}