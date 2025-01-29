public abstract class Car {
    protected Company company;
    protected String modelName;
    protected short modelYear;
    protected String color;
    protected long price;
    protected short horsePower;
    protected short maxSpeed;
    protected short currentSpeed;
    protected boolean isAutomatic;
    protected boolean isFourWheelDrive;
    protected boolean engineStart;
    protected long totalDistanceCovered;
    protected int currentDriveDistance;
    protected int routeDistance;

    public Car(Company company, String modelName, short modelYear, String color, long price, short horsePower, short maxSpeed, boolean isAutomatic, boolean isFourWheelDrive) {
        this.company = company;
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.color = color;
        this.price = price;
        this.horsePower = horsePower;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = 0;
        this.isAutomatic = isAutomatic;
        this.isFourWheelDrive = isFourWheelDrive;
        this.totalDistanceCovered = 0;
        this.currentDriveDistance = 0;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public short getModelYear() {
        return modelYear;
    }

    public void setModelYear(short modelYear) {
        this.modelYear = modelYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public short getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(short horsePower) {
        this.horsePower = horsePower;
    }

    public short getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(short maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public short getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(short currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean automatic) {
        isAutomatic = automatic;
    }

    public boolean isFourWheelDrive() {
        return isFourWheelDrive;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {
        isFourWheelDrive = fourWheelDrive;
    }

    public boolean isEngineStart() {
        return engineStart;
    }

    public void setEngineStart(boolean engineStart) {
        this.engineStart = engineStart;
    }

    public long getTotalDistanceCovered() {
        return totalDistanceCovered;
    }

    public void setTotalDistanceCovered(long totalDistanceCovered) {
        this.totalDistanceCovered = totalDistanceCovered;
    }

    public int getCurrentDriveDistance() {
        return currentDriveDistance;
    }

    public void startEngine() {
        this.engineStart = true;
    }

    public abstract void startDrive(int routeDistance);

    public abstract void applyBrakes(float count);

    @Override
    public String toString() {
        return  "\nmodelName = " + modelName +
                "\nmodelYear = " + modelYear +
                "\ncolor = " + color +
                "\nprice = " + price +
                "\nhorsePower = " + horsePower +
                "\nmaxSpeed = " + maxSpeed +
                "\ncurrentSpeed = " + currentSpeed +
                "\nisAutomatic = " + isAutomatic +
                "\nisFourWheelDrive = " + isFourWheelDrive +
                "\nengineStart = " + engineStart;
    }
}