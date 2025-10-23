package unidad2;

class Package {
    private String trackingCode;
    private double weight;
    
    // Constructor
    public Package(String trackingCode, double weight) {
        this.trackingCode = trackingCode;
        this.weight = weight;
    }
    
    // Getters and Setters
    public String getTrackingCode() {
        return trackingCode;
    }
    
    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    // Method to display package information
    public void showPackage() {
        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("║      PACKAGE INFORMATION          ║");
        System.out.println("╠═══════════════════════════════════╣");
        System.out.printf("║ Tracking Code: %-18s ║%n", trackingCode);
        System.out.printf("║ Weight:        %-10.2f kg      ║%n", weight);
        System.out.println("╚═══════════════════════════════════╝");
    }
}
