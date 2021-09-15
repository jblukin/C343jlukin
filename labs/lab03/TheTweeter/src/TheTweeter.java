	import java.util.*;
	
	
	public class TheTweeter {
		
		private ArrayList<TweetClass> tweets = new ArrayList<TweetClass>();
		
		public TweetClass get(String author) {

			for (TweetClass tweet: tweets) {
				if(tweet.getTweetAuthor().equals(author)) {
					return tweet;
				}
			}
			return null;

		}
		
		public void add(TweetClass tweet) {
		
			tweets.add(tweet);
		
		}

		public void remove(String author) {
			
			for (int i = 0; i < tweets.size(); i++) {
				TweetClass tweet = tweets.get(i);
				if(tweet.getTweetAuthor().equals(author)) {
					tweets.remove(tweet);
					i--;
				}
			}

		}
		
		public static void main(String[] args) {
			
			TheTweeter tweeter = new TheTweeter();
			
			tweeter.add(new TweetClass("This is my first Tweet!","Jonah"));
			tweeter.add(new TweetClass("This is my second Tweet!","Jonah"));
			tweeter.add(new TweetClass("This is the Tweet!","Lukin"));
			tweeter.add(new TweetClass("This is a Tweet!","Lukin"));
			tweeter.add(new TweetClass("I am a Knight!","Arthur"));
			tweeter.add(new TweetClass("The Knight King!","Boyle"));
		
			System.out.println(tweeter.tweets);
			
			tweeter.remove("Lukin");
			
			System.out.println(tweeter.tweets);
			
			System.out.println(tweeter.get("Arthur"));
		
		}
		
	}
