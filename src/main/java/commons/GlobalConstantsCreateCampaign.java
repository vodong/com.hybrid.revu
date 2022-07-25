package commons;

import lombok.Getter;

@Getter
public class GlobalConstantsCreateCampaign {
	private static GlobalConstantsCreateCampaign globalInstanceCreateCampaign;

	public static synchronized GlobalConstantsCreateCampaign getGlobalConstantsCreateCampaign() {
		if (globalInstanceCreateCampaign == null) {
			globalInstanceCreateCampaign = new GlobalConstantsCreateCampaign();
		}
		return globalInstanceCreateCampaign;
	}

	// Campaign Information Korea
	private final String campaignLinkKR = "캠페인";
	private final String campaignScreeningLinkKR = "캠페인 심사";
	private final String campaignListLinkKR = "캠페인 리스트";
	private final String newCampaignRegistrationKR = "새 캠페인 등록";
	private final String campaignRegisterTitleKR = "캠페인 등록";
	private final String advertiserAreaTitleKR = "";
	private final String scopeAreaTitleKR = "";
	private final String influencerAreaTitleKR = "";
	private final String productPointAreaTitleKR = "";
	private final String campaignAreaTitleKR = "";
	private final String contentAreaTitleKR = "";
	private final String scheduleAreaTitleKR = "";
	private final String temprorarySaveButtonKR = "";
	private final String createButtonKR = "";
	private final String previewButtonKR = "";

	// Campaign Information Taiwan
	private final String campaignLinkTW = "";
	private final String campaignScreeningLinkTW = "";
	private final String campaignListLinkTW = "";
	private final String newCampaignRegistrationTW = "";
	private final String campaignRegisterTitleTW = "";
	private final String advertiserAreaTitleTW = "";
	private final String scopeAreaTitleTW = "";
	private final String influencerAreaTitleTW = "";
	private final String productPointAreaTitleTW = "";
	private final String campaignAreaTitleTW = "";
	private final String contentAreaTitleTW = "";
	private final String scheduleAreaTitleTW = "";
	private final String temprorarySaveButtonTW = "";
	private final String createButtonTW = "";
	private final String previewButtonTW = "";

	// Campaign Information English
	private final String campaignLinkEN = "Campaign";
	private final String campaignScreeningLinkEN = "Campaign screening";
	private final String campaignListLinkEN = "Campaign List";
	private final String newCampaignRegistrationEN = "New Campaign Registration";
	private final String campaignRegisterTitleEN = "Campaign Register";
	private final String advertiserAreaTitleEN = "Advertiser";
	private final String scopeAreaTitleEN = "Scope";
	private final String influencerAreaTitleEN = "Influencer";
	private final String productPointAreaTitleEN = "Product/Point";
	private final String campaignAreaTitleEN = "Campaign";
	private final String contentAreaTitleEN = "Content";
	private final String scheduleAreaTitleEN = "Schedule";
	private final String temprorarySaveButtonEN = "Temporay save";
	private final String createButtonEN = "Create";
	private final String previewButtonEN = "Preview";
	private final String partnerTextboxLabelEN = "Partner";
	private final String advertiseBrandLabelEN = "Advertise(Brand)";
	private final String SalesrepLabelEN = "Sales rep";
	private final String channelLabelEN = "Channel";
	private final String recruitmentRangeLabelEN = "Recruitment range";
	private final String publicRadioButtonEN = "Public";
	private final String proOnlyRadioButtonEN = "Pro only";
	private final String privateRadioButtonEN = "Private";
	private final String SNSLabelEN = "SNS";
	private final String instagramRadioButtonEN = "Instagram";
	private final String youtubeRadioButtonEN = "Youtube";
	private final String numberOfInfluencersLabelEN = "Number of influencers";
	private final String numberOfInfluencersPlaceHolderEN = "Enter only numbers";
	private final String numberOfContentsLabelEN = "Number of contents (per influencer)";
	private final String numberOfContentsRadioButtonEN = "1";
	private final String typeLableEN = "Type";
	private final String productRadioButtonEN = "Product";
	private final String placeRadioButtonEN = "Place";
	private final String product1LabelTextboxEN = "Product1";
	private final String product1PlaceholderTextboxEN = "Enter product name";
	private final String product1AddButtonEN = "+ Add";
	private final String setOptionsLableEN = "Set options";
	private final String setRadioButtonEN = "Set";
	private final String notSetRadioButtonEN = "Not Set";
	private final String optionInformationLableEN = "Option information";
	private final String optionNamePlaceholderEN = "Option name";
	private final String optionValuePlaceholderEN = "Enter option value (separated by commas without spaces)";
	private final String productPriceLabelEN = "Product price";
	private final String productPricePlaceholderEN = "Enter only numbers";
	private final String productDescriptionsLableEN = "Product descriptions";
	private final String productDescriptionsPlaceholderEN = "Enter product escription (ex. introduction, price, actual measurement)";
	private final String productUrlLabelEN = "Product URL";
	private final String productUrlPlaceholderEN = "https://www.yours.com";
	private final String pointAmountLabelEN = "Enter numbers only";
	private final String noPointsProvidedLabelEN = "No points provided";
	private final String campaignNameLabelEN = "Campaign name";
	private final String campaignNamePlaceholderEN = "'['Brand name']' Enter campaign name";
	private final String mainThumbnailLabelEN = "Main thumbnail";
	private final String uploadButtonEN = "Upload";
	private final String mainThumbnailCautionTextEN = "400X400px / JPG, PNG / less than 20MB (maximum 1)";
	private final String detailThumbnailLabelEN = "Detail thumbnails";
	private final String detailThumbnailCautionTextEN = "760px or more in width / JPG, PNG / less than 20MB (up to 3)";
	private final String videoUrlYoutubeLabelEN = "Video URL(Youtube)";
	private final String videoUrlYoutubePlaceholderEN = "https://www.youtube.com";
	private final String campaignGuidelineLabelEN = "Campaign guideline";
	private final String campaignautionLableEN = "Campaign caution";
	private final String contentMissionLabelEN = "Content missions";
	private final String contentMissionPlaceholderEN = "Enter mission details";
	private final String detailGuidelineLabelEN = "Detail guideline";
	private final String detailGuidelineCautionTextEN = "PDF / less than 20 MB (maximum 1)";
	private final String requiredHashtagsLabelEN = "Required hashtags";
	private final String requiredHashtagsPlaceholderEN = "Enter hashtag (up to 10)";
	private final String addHashtagsButtonEN = "+ Add hashtags";
	private final String applyIndividualHashtagsCheckBoxEN = "Apply individual hashtags";
	private final String optionalhashtagsLabelEN = "Optional hashtags";
	private final String optionalhashtagsPlaceholderEN = "Input hashtags (up to 10)";
	private final String personTagsLabelEN = "Person tags";
	private final String personTagsPlaceholderEN = "Enter hashtag (up to 3)";
	private final String receiveInformationLableEN = "Receive information";
	private final String phoneNumberCheckBoxEN = "Phone number";
	private final String shippingInformationCheckBoxEN = "Shipping Information";
	private final String bankAccountCheckBoxEN = "Bank account";
	private final String surveyLabelEN = "Survey 1";
	private final String useOfContentLabelEN = "Use of Content";
	private final String useRadioButtonEN = "Use";
	private final String nonUseRadioButtonEN = "Nonuse";
	private final String boundariesLabelEN = "Boundaries";
	private final String commonLicenseLabelEN = "Common license";
	private final String commercialLicenseEN = "Commercial license";
	private final String licenseColumnNameAtTableEN = "License";
	private final String boundariesColumnNameAtTableEN = "Boundaries";
	private final String contentCommonLicenseAtRown1EN = "Used for the advertiser";
	private final String contentCommonLicenseAtRown2EN = "Providing the original images and videos";
	private final String contentCommonLicenseAtRown3EN = "Disallowing the adaptations of the content";
	private final String contentCommercialLicenseAtRown1EN = "Including the boundaries of Common License";
	private final String contentCommercialLicenseAtRown2EN = "Used for the advertiser's online and SNS commercial contents";
	private final String contentCommercialLicenseAtRown3EN = "Providing the original images and videos";
	private final String contentCommercialLicenseAtRown4EN = "Allowing the adaptations of the content (Including the right of the portrait and name)";
	private final String periodsLabelEN = "Periods";
	private final String periods1MonthRadioButtonEN = "1 month";
	private final String periods3MonthsRadioButtonEN = "3 months";
	private final String periods6MonthsRadioButtonEN = "6 months";
	private final String periods12MonthsRadioButtonEN = "12 months";
	private final String draftReviewLabelEN = "Draft review";
	private final String reviewRadioButtonEN = "Review";
	private final String NotReviewRadioButtonEN = "Not review";
	private final String draftReviewerLabelEN = "Draft Reviewer";
	private final String partnerRadioButtonEN = "Partner";
	private final String startDatePlaceHolderEN = "Start date";
	private final String endDatePlaceHolderEN = "End date";
	private final String applicationDateLabelEN = "Application";
	private final String selectionDateLabelEN = "Selection";
	private final String draftSubmitDateLabelEN = "Draft submit";
	private final String draftReviewDateLabelEN = "Draft review";
	private final String contentPostDateLabelEN = "Content post";
	private final String errorMessageEN = "This field is required";
	private final String errorMessageAfterSeachingEN = "Results not found.";
	private final String errorMessageUploadLargerImageEN = "This file is too large. Please select a file less than 20MB.";
}
