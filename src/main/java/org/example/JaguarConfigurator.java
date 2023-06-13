package org.example;

public class JaguarConfigurator implements CarConfigurator {
    private CarModel model = null;

    public JaguarConfigurator(CarModel model) {
        this.model = model;
    }

    public JaguarConfigurator() {
    }

    @Override
    public CarModel selectModel(String model) {
        this.model = new JaguarModel(JaguarModelList.XJ);
        if(model.equals(String.valueOf(JaguarModelList.XF))) {
            this.model = new JaguarModel(JaguarModelList.XF);
        }
        return this.model;
    }

    @Override
    public String summarize() {
        String brandName = "Jaguar";
        String modelSummary = model.summarize();
        return "%s %s".formatted(brandName, modelSummary);
    }
}
