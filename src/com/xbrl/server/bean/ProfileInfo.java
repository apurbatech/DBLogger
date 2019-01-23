package com.xbrl.server.bean;


/**
 *
 * @author Nazmul Hasan
 */
public class ProfileInfo
{
    private int profileId;
    private int userId;
    //New change by Nazmul on 1st november
    //companyId and companyName is added
    private int companyId;
    private String companyName;
    private String profileName;
    private String entityName;
    private String uniqueIdentifier;
    private String defaultCurrency;
    private String defaultPrecision;
    private String reportingAgency;
    private String companyURL;
    
    private String ticker;
    private boolean excludeTicker;

    private String lastYearEnd;
    private String inceptionDate;

    private String createDate;
    private String lastUpdate;

    public boolean voluntaryFiler;
    public boolean seasonedIssuer;
    public String category;

    public String proofUserName;
    public String proofPassword;

    public String ccc;
    public String defaultEdgarContactPerson;
    public String defaultEdgarContactPhone;
    public int sic;
    public String industry;
    public String languageCode;
    public String languageName;

    public boolean shellCompany;
    
    public boolean emergingGrowthCompanyFlag;
    public boolean exTransitionPeriodFlag;
    
    private boolean entitySmallBusiness;

    public void setShellCompany(boolean shellCompany) {
        this.shellCompany = shellCompany;
    }

    public boolean isShellCompany() {
        return shellCompany;
    }

    
    
    public String getCcc() {
        return ccc;
    }

    public void setCcc(String ccc) {
        this.ccc = ccc;
    }

    public void setDefaultEdgarContactPerson(String defaultEdgarContactPerson) {
        this.defaultEdgarContactPerson = defaultEdgarContactPerson;
    }

    public void setDefaultEdgarContactPhone(String defaultEdgarContactPhone) {
        this.defaultEdgarContactPhone = defaultEdgarContactPhone;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public void setSic(int sic) {
        this.sic = sic;
    }

    public String getDefaultEdgarContactPerson() {
        return defaultEdgarContactPerson;
    }

    public String getDefaultEdgarContactPhone() {
        return defaultEdgarContactPhone;
    }

    public String getIndustry() {
        return industry;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public String getLanguageName() {
        return languageName;
    }

    public int getSic() {
        return sic;
    }


    /**
     * return project id
     * @return
     */
    public int getProfileId() {
        return profileId;
    }

    /**
     * set profile id
     * @param profileId
     */
    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCompanyId(int companyId){
        this.companyId = companyId;
    }

    public int getCompanyId(){
        return this.companyId;
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getCompanyName(){
        return this.companyName;
    }

    /**
     * @return the profileName
     */
    public String getProfileName() {
        return profileName;
    }

    /**
     * @param profileName the profileName to set
     */
    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    /**
     * @return the entityName
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * @param entityName the entityName to set
     */
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    /**
     * @return the uniqueIdentifier
     */
    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    /**
     * @param uniqueIdentifier the uniqueIdentifier to set
     */
    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    /**
     * @return the defaultCurrency in USD like...
     */
    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    /**
     * @param defaultCurrency the defaultCurrency to set
     */
    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    /**
     * @return the defaultPrecision
     */
    public String getDefaultPrecision() {
        return defaultPrecision;
    }

    /**
     * @param defaultPrecision the defaultPrecision to set
     */
    public void setDefaultPrecision(String defaultPrecision) {
        this.defaultPrecision = defaultPrecision;
    }

    /**
     * @return the reportingAgency
     */
    public String getReportingAgency() {
        return reportingAgency;
    }

    /**
     * @param reportingAgency the reportingAgency to set
     */
    public void setReportingAgency(String reportingAgency) {
        this.reportingAgency = reportingAgency;
    }

    /**
     * @return the createDate
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the lastUpdate
     */
    public String getLastUpdate() {
        return lastUpdate;
    }

    /**
     * @param lastUpdate the lastUpdate to set
     */
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * @return the ticker
     */
    public String getTicker() {
        return ticker;
    }

    /**
     * @param ticker the ticker to set
     */
    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    /**
     * @return the lastYearEnd
     */
    public String getLastYearEnd() {
        return lastYearEnd;
    }

    /**
     * @param lastYearEnd the lastYearEnd to set
     */
    public void setLastYearEnd(String lastYearEnd) {
        this.lastYearEnd = lastYearEnd;
    }

    /**
     * @return the inceptionDate
     */
    public String getInceptionDate() {
        return inceptionDate;
    }

    /**
     * @param inceptionDate the inceptionDate to set
     */
    public void setInceptionDate(String inceptionDate) {
        this.inceptionDate = inceptionDate;
    }

    /**
     * @return the companyURL
     */
    public String getCompanyURL() {
        return companyURL;
    }

    /**
     * @param companyURL the companyURL to set
     */
    public void setCompanyURL(String companyURL) {
        this.companyURL = companyURL;
    }

    public void setVoluntaryFiler(boolean voluntaryFiler){
        this.voluntaryFiler = voluntaryFiler;
    }

    public boolean getVoluntaryFiler(){
        return voluntaryFiler;
    }

    public void setSeasonedIssuer(boolean seasonedIssuer){
        this.seasonedIssuer = seasonedIssuer;
    }

    public boolean getSeasonedIssuer(){
        return seasonedIssuer;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return category;
    }

    public void setProofUserName(String proofUserName){
        this.proofUserName = proofUserName;
    }

    public String getProofUserName(){
        return proofUserName;
    }

    public void setProofPassword(String proofPassword){
        this.proofPassword = proofPassword;
    }

    public String getProofPassword(){
        return proofPassword;
    }

    public boolean isExcludeTicker() {
        return excludeTicker;
    }

    public void setExcludeTicker(boolean excludeTicker) {
        this.excludeTicker = excludeTicker;
    }

    public boolean isEmergingGrowthCompanyFlag() {
        return emergingGrowthCompanyFlag;
    }

    public void setEmergingGrowthCompanyFlag(boolean emergingGrowthCompanyFlag) {
        this.emergingGrowthCompanyFlag = emergingGrowthCompanyFlag;
    }

    public boolean isExTransitionPeriodFlag() {
        return exTransitionPeriodFlag;
    }

    public void setExTransitionPeriodFlag(boolean exTransitionPeriodFlag) {
        this.exTransitionPeriodFlag = exTransitionPeriodFlag;
    }

    public boolean isEntitySmallBusiness() {
        return entitySmallBusiness;
    }

    public void setEntitySmallBusiness(boolean entitySmallBusiness) {
        this.entitySmallBusiness = entitySmallBusiness;
    }
    
    @Override
    public String toString()
    {
        String strOutput = "";
        strOutput   += "profileId: "+profileId+", userId: "+userId+", companyId: "+companyId+", companyName: "+companyName+", \n";
        strOutput   += "profileName: "+profileName+", entityName: "+entityName+", uniqueIdentifier: "+uniqueIdentifier+", defaultCurrency: "+defaultCurrency+", \n";
        strOutput   += "defaultPrecision: "+defaultPrecision+", reportingAgency: "+reportingAgency+", companyURL: "+companyURL+", ticker: "+ticker+", \n";
        strOutput   += "excludeTicker: "+excludeTicker+", lastYearEnd: "+lastYearEnd+", inceptionDate: "+inceptionDate+", lastUpdate: "+lastUpdate+", \n";
        strOutput   += "voluntaryFiler: "+voluntaryFiler+", seasonedIssuer: "+seasonedIssuer+", category: "+category+", proofUserName: "+proofUserName+", \n";
        strOutput   += "ccc: "+ccc+", defaultEdgarContactPerson: "+defaultEdgarContactPerson+", defaultEdgarContactPhone: "+defaultEdgarContactPhone+", sic: "+sic+", \n";
        strOutput   += "industry: "+industry+", languageCode: "+languageCode+", languageName: "+languageName+", shellCompany: "+shellCompany+", emergingGrowthCompanyFlag: "+emergingGrowthCompanyFlag+", exTransitionPeriodFlag: "+exTransitionPeriodFlag+", entitySmallBusiness: "+entitySmallBusiness;
        return strOutput;
    }
}