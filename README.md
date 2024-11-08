# MatchEat - Restaurant Recommendation App

**MatchEat** is an Android app designed to recommend restaurants based on user preferences such as cuisine and rating. It uses a content-based filtering model hosted on Google Colab to provide real-time suggestions. The app also integrates with Google Maps to show restaurant locations.

## Features

- Input preferred cuisine and minimum rating.
- Receive personalized restaurant recommendations.
- View restaurant locations on Google Maps.
- Clean, user-friendly interface.

## How to Run

### Prerequisites

1. **Google Colab Model**:
   - First, run the AI model in Google Colab to get the `ngrok` URL. You can access the Colab model [here](https://colab.research.google.com/drive/17C9lbVs1AHfD1GT8RtDEvZy89FLDLLbA#scrollTo=V3F3RezaELvn).
   - This URL will be used by the app to communicate with the AI model and fetch restaurant recommendations.

2. **Android Studio**: 
   - Clone this repository.
   - Open the project in Android Studio.

### Steps to Run:

1. Run the Google Colab model to get the `ngrok` URL.
2. Replace the `API_URL` in the app with the `ngrok` URL obtained from Colab.
3. Build and run the app on your Android device or emulator.

## Technologies Used

- **Android**: Java, Retrofit2, OkHttpClient
- **Google Colab**: AI model for content-based filtering
- **Ngrok**: Secure tunnel for local API communication