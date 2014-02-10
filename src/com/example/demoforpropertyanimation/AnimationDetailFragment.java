package com.example.demoforpropertyanimation;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demoforpropertyanimation.dummy.DummyContent;
import com.example.demoforpropertyanimation.myinterpolator.BackEaseIn;
import com.example.demoforpropertyanimation.myinterpolator.BackEaseInOut;
import com.example.demoforpropertyanimation.myinterpolator.BackEaseOut;
import com.example.demoforpropertyanimation.myinterpolator.BounceEaseIn;
import com.example.demoforpropertyanimation.myinterpolator.BounceEaseInOut;
import com.example.demoforpropertyanimation.myinterpolator.BounceEaseOut;
import com.example.demoforpropertyanimation.myinterpolator.CircularEaseIn;
import com.example.demoforpropertyanimation.myinterpolator.CircularEaseInOut;
import com.example.demoforpropertyanimation.myinterpolator.CircularEaseOut;
import com.example.demoforpropertyanimation.myinterpolator.CubicEaseIn;
import com.example.demoforpropertyanimation.myinterpolator.CubicEaseInOut;
import com.example.demoforpropertyanimation.myinterpolator.CubicEaseOut;
import com.example.demoforpropertyanimation.myinterpolator.ElasticEaseIn;
import com.example.demoforpropertyanimation.myinterpolator.ElasticEaseInOut;
import com.example.demoforpropertyanimation.myinterpolator.ElasticEaseOut;
import com.example.demoforpropertyanimation.myinterpolator.ExponentialEaseIn;
import com.example.demoforpropertyanimation.myinterpolator.ExponentialEaseInOut;
import com.example.demoforpropertyanimation.myinterpolator.ExponentialEaseOut;
import com.example.demoforpropertyanimation.myinterpolator.QuadraticEaseIn;
import com.example.demoforpropertyanimation.myinterpolator.QuadraticEaseInOut;
import com.example.demoforpropertyanimation.myinterpolator.QuadraticEaseOut;
import com.example.demoforpropertyanimation.myinterpolator.QuarticEaseIn;
import com.example.demoforpropertyanimation.myinterpolator.QuarticEaseInOut;
import com.example.demoforpropertyanimation.myinterpolator.QuarticEaseOut;
import com.example.demoforpropertyanimation.myinterpolator.QuinticEaseIn;
import com.example.demoforpropertyanimation.myinterpolator.QuinticEaseInOut;
import com.example.demoforpropertyanimation.myinterpolator.QuinticEaseOut;
import com.example.demoforpropertyanimation.myinterpolator.SineEaseIn;
import com.example.demoforpropertyanimation.myinterpolator.SineEaseInOut;
import com.example.demoforpropertyanimation.myinterpolator.SineEaseOut;
import com.example.demoforpropertyanimation.view.DrawView;
import com.example.demoforpropertyanimation.view.TimeDrawView;
import com.example.demoforpropertyanimation.view.TimeDrawViewV4;
import com.example.demoforpropertyanimation.view.ValueAnimatorDrawView;
import com.example.demoforpropertyanimation.view.ValueAnimatorV4DrawView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;
import com.nineoldandroids.animation.TimeAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

/**
 * A fragment representing a single Animation detail screen. This fragment is
 * either contained in a {@link AnimationListActivity} in two-pane mode (on
 * tablets) or a {@link AnimationDetailActivity} on handsets.
 */
@SuppressLint("NewApi")
public class AnimationDetailFragment extends Fragment implements
		OnClickListener {

	final String TAG = "AnimationDetailFragment";

	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";
	
	final String[] interpolators = new String[] {
			"AccelerateDecelerateInterpolator",
			"AccelerateInterpolator", "AnticipateInterpolator",
			"AnticipateOvershootInterpolator",
			"BounceInterpolator", "CycleInterpolator",
			"DecelerateInterpolator", "OvershootInterpolator",
			"LinearInterpolator"
			,"QuadraticEaseIn","QuadraticEaseOut","QuadraticEaseInOut" 
			,"CubicEaseIn","CubicEaseOut","CubicEaseInOut" 
			,"QuarticEaseIn","QuarticEaseOut","QuarticEaseInOut" 
			,"QuinticEaseIn","QuinticEaseOut","QuinticEaseInOut" 
			,"SineEaseIn","SineEaseOut","SineEaseInOut" 
			,"CircularEaseIn","CircularEaseOut","CircularEaseInOut" 
			,"ExponentialEaseIn","ExponentialEaseOut","ExponentialEaseInOut" 
			,"ElasticEaseIn","ElasticEaseOut","ElasticEaseInOut" 
			,"BackEaseIn","BackEaseOut","BackEaseInOut" 
			,"BounceEaseIn","BounceEaseInOut","BounceEaseOut"};


	final Interpolator[] interpolators_ = new Interpolator[] { 
			
			new AccelerateDecelerateInterpolator(),
			new AccelerateInterpolator(),
			new AnticipateInterpolator(),
			new AnticipateOvershootInterpolator(),
			new BounceInterpolator(),
			new CycleInterpolator(1),
			new DecelerateInterpolator(),
			new OvershootInterpolator(),
			new LinearInterpolator(),
			new QuadraticEaseIn(),
			new QuadraticEaseOut(),
			new QuadraticEaseInOut(),
			new CubicEaseIn(),
			new CubicEaseOut(),
			new CubicEaseInOut(),
			new QuarticEaseIn(),
			new QuarticEaseOut(),
			new QuarticEaseInOut(),
			new QuinticEaseIn(),
			new QuinticEaseOut(),
			new QuinticEaseInOut(),
			new SineEaseIn(),
			new SineEaseOut(),
			new SineEaseInOut(),
			new CircularEaseIn(), 
			new CircularEaseOut(),
			new CircularEaseInOut(),
			new ExponentialEaseIn(),
			new ExponentialEaseOut(),
			new ExponentialEaseInOut(),
			new ElasticEaseIn(),
			new ElasticEaseOut(),
			new ElasticEaseInOut(),
			new BackEaseIn(),
			new BackEaseOut(),
			new BackEaseInOut(),
			new BounceEaseIn(),
			new BounceEaseInOut(),
			new BounceEaseOut()
	};
	
	/**
	 * The dummy content this fragment is presenting.
	 */
	private DummyContent.DummyItem mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public AnimationDetailFragment() {
	}

	int imageAreaState = 0;
	boolean is90 = false;
	boolean isMoveStart = false;
	boolean isCompAnimStart = false;
	boolean isCompAnim2Start = false;
	boolean isCompAnim3Start = false;
	boolean isCompAnim4Start = false;
	boolean isCompAnim5Start = false;

	View titleView;
	View btnRotate;

	View imageArea;

	View btnRotate90;

	DrawView mDrawView;

	View imageArea2;

	View timeAnimationView;

	View complicateAnim1;
	View complicateAnim2;
	View complicateAnim3;
	View complicateAnim4;
	View complicateAnim5;
	
	View value_object;
	View value_area;

	Spinner mSpinnerInterpolator;
	View btnStartValueAnimator; 
	ValueAnimatorDrawView drawValueAnimator;
	ValueAnimatorV4DrawView drawValueAnimatorV4;
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = DummyContent.ITEM_MAP.get(getArguments().getString(
					ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView;
		if (mItem != null) {
			int type = Integer.valueOf(mItem.id);
			if (type == DummyContent.ID_KITKAT_TRANSITIONS) {
				
				rootView = inflater.inflate(
						R.layout.fragment_animation_detail_forkitkat,
						container, false);
				
			} else {
				
				rootView = inflater.inflate(R.layout.fragment_animation_detail,
						container, false);
			}
		} else {
			rootView = inflater.inflate(
					R.layout.fragment_animation_detail_forkitkat, container,
					false);
		}

		// Show the dummy content as text in a TextView.
		if (mItem != null) {
			
			((TextView) rootView.findViewById(R.id.animation_detail))
					.setText(mItem.content);
			
			showAlphaAnimation(rootView);
		}

		getViews(rootView);

		return rootView;
	}

	public void getViews(View rootView) {
		if (rootView != null) {
			if (mItem == null) {
				return;
			}
			titleView = rootView.findViewById(R.id.animation_detail);
			if (titleView != null)
				titleView.setOnClickListener(this);
			btnRotate = rootView.findViewById(R.id.button_for_rotate);
			if (btnRotate != null)
				btnRotate.setOnClickListener(this);

			imageArea = rootView.findViewById(R.id.image_area);
			if (imageArea != null)
				imageArea.setOnClickListener(this);

			btnRotate90 = rootView.findViewById(R.id.button_for_rotate_angle);
			if (btnRotate90 != null)
				btnRotate90.setOnClickListener(this);

			mDrawView = (DrawView) rootView.findViewById(R.id.drawview1);
			if (mDrawView != null) {
				mDrawView.setOnClickListener(this);
				mDrawView.setColor(getResources().getColor(
						R.color.detail_drawview_bg));
			}
			imageArea2 = rootView.findViewById(R.id.move_area2);
			if (imageArea2 != null)

				imageArea2.setOnClickListener(this);

			timeAnimationView = rootView.findViewById(R.id.anim_area);
			if (timeAnimationView != null) {
				timeAnimationView.setOnClickListener(this);

				int type = Integer.valueOf(mItem.id);
				View item = type == DummyContent.ID_PROPERTY_ANIMATIONS ? new TimeDrawView(
						getActivity()) : new TimeDrawViewV4(getActivity());
				item.setId(1204);
				((ViewGroup) timeAnimationView).addView(item);
			}

			complicateAnim1 = rootView.findViewById(R.id.btn_anim1);

			if (complicateAnim1 != null) {
				complicateAnim1.setOnClickListener(this);
			}

			complicateAnim2 = rootView.findViewById(R.id.btn_anim2);

			if (complicateAnim2 != null) {
				complicateAnim2.setOnClickListener(this);
			}

			complicateAnim3 = rootView.findViewById(R.id.btn_anim3);

			if (complicateAnim3 != null) {
				complicateAnim3.setOnClickListener(this);
			}

			complicateAnim4 = rootView.findViewById(R.id.btn_anim4);

			if (complicateAnim4 != null) {
				complicateAnim4.setOnClickListener(this);
			}

			complicateAnim5 = rootView.findViewById(R.id.btn_anim5);

			if (complicateAnim5 != null) {
				complicateAnim5.setOnClickListener(this);
			}

			mSpinnerInterpolator = (Spinner) rootView
					.findViewById(R.id.spin_interpolator);

			if (mSpinnerInterpolator != null) {
				
				mSpinnerInterpolator.setAdapter(new BaseAdapter() {

					@Override
					public View getView(int position, View convertView,
							ViewGroup parent) {

						TextView mTextView = new TextView(getActivity());
						mTextView.setPadding(20, 20, 20, 20);
						mTextView.setSingleLine();
						mTextView.setText(interpolators[position]);
						return mTextView;
					}

					@Override
					public long getItemId(int position) { 
						return 0;
					}

					@Override
					public Object getItem(int position) { 
						return null;
					}

					@Override
					public int getCount() { 
						return interpolators.length;
					}
				});
  
				mSpinnerInterpolator.setOnItemSelectedListener(mInterpolatorSelectedListener);
			}
			
			value_object = rootView.findViewById(R.id.value_object);
			value_area = rootView.findViewById(R.id.value_area);

			btnStartValueAnimator = rootView.findViewById(R.id.btn_startAnim);
			if (btnStartValueAnimator != null) {
				btnStartValueAnimator.setOnClickListener(this);
			}
			 
			int type = Integer.valueOf(mItem.id);
			
			if(type == DummyContent.ID_PROPERTY_ANIMATIONS)
			{
				drawValueAnimator = (ValueAnimatorDrawView)rootView.findViewById(R.id.value_animator_drawview);
			}
			else if(type == DummyContent.ID_PROPERTY_ANIMATIONS_FOR_V4)
			{
				drawValueAnimatorV4 = (ValueAnimatorV4DrawView)rootView.findViewById(R.id.value_animator_v4_drawview);
			}
		}
	}

	@TargetApi(19)
	public void showAlphaAnimation(final View view) {
		if (mItem != null) {
			int type = Integer.valueOf(mItem.id);
			switch (type) {
			case DummyContent.ID_OLD_ANIMATIONS:

				view.clearAnimation();
				AlphaAnimation mAlphaAnimation = new AlphaAnimation(0, 1);
				mAlphaAnimation.setDuration(DummyContent.ANIMATION_DURATION);
				view.startAnimation(mAlphaAnimation);

				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS:

				view.setAlpha(0);
				view.animate().setDuration(DummyContent.ANIMATION_DURATION)
						.alpha(1);

				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS_FOR_V4:

				ViewPropertyAnimator.animate(view).setDuration(1); // 先快速处于透明
				ViewPropertyAnimator.animate(view).alpha(0);
				ViewPropertyAnimator.animate(view).setListener(
						new AnimatorListener() {
							@Override
							public void onAnimationStart(Animator arg0) {

							}

							@Override
							public void onAnimationRepeat(Animator arg0) {

							}

							@Override
							public void onAnimationEnd(Animator arg0) {

								ViewPropertyAnimator.animate(view).setDuration(
										DummyContent.ANIMATION_DURATION);
								ViewPropertyAnimator.animate(view).alpha(1);
							}

							@Override
							public void onAnimationCancel(Animator arg0) {

							}
						});

				break;
			case DummyContent.ID_KITKAT_TRANSITIONS:

				if (view instanceof ViewGroup) {
					TransitionManager mTransitionManager = new TransitionManager();
					Scene mScene = new Scene((ViewGroup) view);
					mTransitionManager.transitionTo(mScene);
				} else {
					Toast.makeText(getActivity(), "The view is no ViewGroup",
							Toast.LENGTH_SHORT).show();
				}

				break;
			}
		}
	}

	public void showRotationSequence(final View view) {
		if (mItem != null) {
			int type = Integer.valueOf(mItem.id);
			switch (type) {
			case DummyContent.ID_OLD_ANIMATIONS:

				AnimationSet mAnimationSet = new AnimationSet(true);
				RotateAnimation mRotateAnimation = new RotateAnimation(0, 360,
						view.getWidth() / 2, view.getHeight() / 2);
				mRotateAnimation.setDuration(DummyContent.ANIMATION_DURATION);
				mRotateAnimation.setInterpolator(new DecelerateInterpolator());
				mRotateAnimation.setFillAfter(true);
				mAnimationSet.addAnimation(mRotateAnimation);
				mRotateAnimation = new RotateAnimation(360, 0,
						view.getWidth() / 2, view.getHeight() / 2);
				mRotateAnimation.setFillAfter(true);
				mRotateAnimation.setFillBefore(true);
				mRotateAnimation.setDuration(DummyContent.ANIMATION_DURATION);
				mRotateAnimation.setInterpolator(new DecelerateInterpolator());
				mRotateAnimation
						.setStartOffset(DummyContent.ANIMATION_DURATION);
				mAnimationSet.addAnimation(mRotateAnimation);
				view.startAnimation(mAnimationSet);

				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS:

				android.animation.ObjectAnimator objectAnimator = android.animation.ObjectAnimator
						.ofFloat(view, "rotation", 0f, 360f);
				objectAnimator.setInterpolator(new DecelerateInterpolator());
				objectAnimator.setDuration(DummyContent.ANIMATION_DURATION);

				android.animation.ObjectAnimator objectAnimatorSecond = android.animation.ObjectAnimator
						.ofFloat(view, "rotation", 360f, 0f);
				objectAnimatorSecond
						.setInterpolator(new DecelerateInterpolator());
				objectAnimatorSecond
						.setDuration(DummyContent.ANIMATION_DURATION);

				android.animation.AnimatorSet mAnimatorSet = new android.animation.AnimatorSet();
				mAnimatorSet.playSequentially(objectAnimator,
						objectAnimatorSecond);
				mAnimatorSet.start();
				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS_FOR_V4:

				ObjectAnimator mV4ObjectAnimator = ObjectAnimator.ofFloat(view,
						"rotation", 0f, 360f);
				mV4ObjectAnimator.setInterpolator(new DecelerateInterpolator());
				mV4ObjectAnimator.setDuration(DummyContent.ANIMATION_DURATION);

				ObjectAnimator mV4ObjectAnimatorSecond = ObjectAnimator
						.ofFloat(view, "rotation", 360f, 0f);
				mV4ObjectAnimatorSecond
						.setInterpolator(new DecelerateInterpolator());
				mV4ObjectAnimatorSecond
						.setDuration(DummyContent.ANIMATION_DURATION);

				AnimatorSet v4AnimatorSet = new AnimatorSet();
				v4AnimatorSet.playSequentially(mV4ObjectAnimator,
						mV4ObjectAnimatorSecond);
				v4AnimatorSet.start();

				break;
			case DummyContent.ID_KITKAT_TRANSITIONS:

				Toast.makeText(getActivity(), "The view is no ViewGroup",
						Toast.LENGTH_SHORT).show();
				break;
			}
		}
	}

	public void showImageAreaChange(final View view) {
		if (mItem != null) {
			int type = Integer.valueOf(mItem.id);
			switch (type) {
			case DummyContent.ID_OLD_ANIMATIONS:

				View child = view.findViewById(R.id.image_earth);

				child.clearAnimation();

				TranslateAnimation mTranslateAnimation = new TranslateAnimation(
						0, view.getWidth() - child.getWidth(), 0,
						view.getHeight() - child.getHeight());
				mTranslateAnimation.setFillAfter(true);
				mTranslateAnimation.setFillBefore(true);
				mTranslateAnimation
						.setDuration(DummyContent.ANIMATION_DURATION);

				TranslateAnimation mTranslateAnimation2 = new TranslateAnimation(
						0, -(view.getWidth() - child.getWidth()), 0, 0);
				mTranslateAnimation2.setFillAfter(true);
				mTranslateAnimation2.setFillBefore(true);
				mTranslateAnimation2
						.setStartOffset(DummyContent.ANIMATION_DURATION);
				mTranslateAnimation2
						.setDuration(DummyContent.ANIMATION_DURATION);

				TranslateAnimation mTranslateAnimation3 = new TranslateAnimation(
						0, (view.getWidth() - child.getWidth()), 0,
						-(view.getHeight() - child.getHeight()));
				mTranslateAnimation3.setFillAfter(true);
				mTranslateAnimation3.setFillBefore(true);
				mTranslateAnimation3
						.setStartOffset(DummyContent.ANIMATION_DURATION * 2);
				mTranslateAnimation3
						.setDuration(DummyContent.ANIMATION_DURATION);

				TranslateAnimation mTranslateAnimation4 = new TranslateAnimation(
						0, 0, 0, view.getHeight() - child.getHeight());
				mTranslateAnimation4.setFillAfter(true);
				mTranslateAnimation4.setFillBefore(true);
				mTranslateAnimation4
						.setStartOffset(DummyContent.ANIMATION_DURATION * 3);
				mTranslateAnimation4
						.setDuration(DummyContent.ANIMATION_DURATION);

				TranslateAnimation mTranslateAnimation5 = new TranslateAnimation(
						0, -(view.getWidth() - child.getWidth()), 0,
						-(view.getHeight() - child.getHeight()));
				mTranslateAnimation5.setFillAfter(true);
				mTranslateAnimation5.setFillBefore(true);
				mTranslateAnimation5
						.setStartOffset(DummyContent.ANIMATION_DURATION * 4);
				mTranslateAnimation5
						.setDuration(DummyContent.ANIMATION_DURATION);

				AnimationSet mAnimationSet = new AnimationSet(true);
				mAnimationSet.addAnimation(mTranslateAnimation);
				mAnimationSet.addAnimation(mTranslateAnimation2);
				mAnimationSet.addAnimation(mTranslateAnimation3);
				mAnimationSet.addAnimation(mTranslateAnimation4);
				mAnimationSet.addAnimation(mTranslateAnimation5);

				child.startAnimation(mAnimationSet);

				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS: {

				child = view.findViewById(R.id.image_earth);

				float x = child.getX();

				float y = child.getY();

				android.animation.AnimatorSet mAnimatorSet = new android.animation.AnimatorSet();

				android.animation.PropertyValuesHolder pvhX = android.animation.PropertyValuesHolder
						.ofFloat("x", 0);
				android.animation.PropertyValuesHolder pvhY = android.animation.PropertyValuesHolder
						.ofFloat("y", 0);
				android.animation.ObjectAnimator mObjectAnimator1 = android.animation.ObjectAnimator
						.ofPropertyValuesHolder(child, pvhX, pvhY).setDuration(
								DummyContent.ANIMATION_DURATION);

				android.animation.PropertyValuesHolder pvhX2 = android.animation.PropertyValuesHolder
						.ofFloat("x", view.getWidth() - child.getWidth());
				android.animation.PropertyValuesHolder pvhY2 = android.animation.PropertyValuesHolder
						.ofFloat("y", view.getHeight() - child.getHeight());
				android.animation.ObjectAnimator mObjectAnimator2 = android.animation.ObjectAnimator
						.ofPropertyValuesHolder(child, pvhX2, pvhY2)
						.setDuration(DummyContent.ANIMATION_DURATION);

				android.animation.PropertyValuesHolder pvhX3 = android.animation.PropertyValuesHolder
						.ofFloat("x", 0);
				android.animation.PropertyValuesHolder pvhY3 = android.animation.PropertyValuesHolder
						.ofFloat("y", view.getHeight() - child.getHeight());
				android.animation.ObjectAnimator mObjectAnimator3 = android.animation.ObjectAnimator
						.ofPropertyValuesHolder(child, pvhX3, pvhY3)
						.setDuration(DummyContent.ANIMATION_DURATION);

				android.animation.PropertyValuesHolder pvhX4 = android.animation.PropertyValuesHolder
						.ofFloat("x", view.getWidth() - child.getWidth());
				android.animation.PropertyValuesHolder pvhY4 = android.animation.PropertyValuesHolder
						.ofFloat("y", 0);
				android.animation.ObjectAnimator mObjectAnimator4 = android.animation.ObjectAnimator
						.ofPropertyValuesHolder(child, pvhX4, pvhY4)
						.setDuration(DummyContent.ANIMATION_DURATION);

				android.animation.PropertyValuesHolder pvhX5 = android.animation.PropertyValuesHolder
						.ofFloat("x", x);
				android.animation.PropertyValuesHolder pvhY5 = android.animation.PropertyValuesHolder
						.ofFloat("y", y);
				android.animation.ObjectAnimator mObjectAnimator5 = android.animation.ObjectAnimator
						.ofPropertyValuesHolder(child, pvhX5, pvhY5)
						.setDuration(DummyContent.ANIMATION_DURATION);

				mAnimatorSet.playSequentially(mObjectAnimator1,
						mObjectAnimator2, mObjectAnimator3, mObjectAnimator4,
						mObjectAnimator5);
				mAnimatorSet.start();
			}
				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS_FOR_V4: {
				child = view.findViewById(R.id.image_earth);

				float x = child.getX();

				float y = child.getY();

				AnimatorSet mAnimatorSet = new AnimatorSet();

				PropertyValuesHolder pvhX = PropertyValuesHolder
						.ofFloat("x", 0);
				PropertyValuesHolder pvhY = PropertyValuesHolder
						.ofFloat("y", 0);
				ObjectAnimator mObjectAnimator1 = ObjectAnimator
						.ofPropertyValuesHolder(child, pvhX, pvhY).setDuration(
								DummyContent.ANIMATION_DURATION);

				PropertyValuesHolder pvhX2 = PropertyValuesHolder.ofFloat("x",
						view.getWidth() - child.getWidth());
				PropertyValuesHolder pvhY2 = PropertyValuesHolder.ofFloat("y",
						view.getHeight() - child.getHeight());
				ObjectAnimator mObjectAnimator2 = ObjectAnimator
						.ofPropertyValuesHolder(child, pvhX2, pvhY2)
						.setDuration(DummyContent.ANIMATION_DURATION);

				PropertyValuesHolder pvhX3 = PropertyValuesHolder.ofFloat("x",
						0);
				PropertyValuesHolder pvhY3 = PropertyValuesHolder.ofFloat("y",
						view.getHeight() - child.getHeight());
				ObjectAnimator mObjectAnimator3 = ObjectAnimator
						.ofPropertyValuesHolder(child, pvhX3, pvhY3)
						.setDuration(DummyContent.ANIMATION_DURATION);

				PropertyValuesHolder pvhX4 = PropertyValuesHolder.ofFloat("x",
						view.getWidth() - child.getWidth());
				PropertyValuesHolder pvhY4 = PropertyValuesHolder.ofFloat("y",
						0);
				ObjectAnimator mObjectAnimator4 = ObjectAnimator
						.ofPropertyValuesHolder(child, pvhX4, pvhY4)
						.setDuration(DummyContent.ANIMATION_DURATION);

				PropertyValuesHolder pvhX5 = PropertyValuesHolder.ofFloat("x",
						x);
				PropertyValuesHolder pvhY5 = PropertyValuesHolder.ofFloat("y",
						y);
				ObjectAnimator mObjectAnimator5 = ObjectAnimator
						.ofPropertyValuesHolder(child, pvhX5, pvhY5)
						.setDuration(DummyContent.ANIMATION_DURATION);

				mAnimatorSet.playSequentially(mObjectAnimator1,
						mObjectAnimator2, mObjectAnimator3, mObjectAnimator4,
						mObjectAnimator5);
				mAnimatorSet.start();
			}
				break;
			case DummyContent.ID_KITKAT_TRANSITIONS:

				if (view instanceof ViewGroup) {
					TransitionManager mTransitionManager = new TransitionManager();

					if (imageAreaState == 0) {
						View mFirstScene = LayoutInflater
								.from(getActivity())
								.inflate(
										R.layout.fragment_animation_detail_firstscene,
										null);
						mTransitionManager.transitionTo(new Scene(
								(ViewGroup) view, (ViewGroup) mFirstScene));
						imageAreaState = 1;
					} else {
						View mSecondScene = LayoutInflater
								.from(getActivity())
								.inflate(
										R.layout.fragment_animation_detail_secondscene,
										null);
						mTransitionManager.transitionTo(new Scene(
								(ViewGroup) view, (ViewGroup) mSecondScene));
						imageAreaState = 0;
					}
				}

				break;
			}
		}
	}

	public void showRotation90(final View view) {
		if (mItem != null) {
			int type = Integer.valueOf(mItem.id);
			switch (type) {
			case DummyContent.ID_OLD_ANIMATIONS:
				RotateAnimation mRotateAnimation;
				if (is90) {
					mRotateAnimation = new RotateAnimation(90, 0,
							view.getWidth(), view.getHeight() / 2);
				} else {
					mRotateAnimation = new RotateAnimation(0, 90,
							view.getWidth(), view.getHeight() / 2);
				}
				is90 = !is90;
				mRotateAnimation.setDuration(DummyContent.ANIMATION_DURATION);
				mRotateAnimation.setFillAfter(true);
				mRotateAnimation.setFillBefore(true);

				view.startAnimation(mRotateAnimation);

				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS:

				if (is90) {
					view.setPivotX(view.getWidth());
					view.setPivotY(view.getHeight() / 2);
					view.animate().setDuration(DummyContent.ANIMATION_DURATION)
							.rotation(0);
				} else {
					view.setPivotX(view.getWidth());
					view.setPivotY(view.getHeight() / 2);
					view.animate().setDuration(DummyContent.ANIMATION_DURATION)
							.rotation(90);
				}
				is90 = !is90;

				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS_FOR_V4:
				if (is90) {
					ViewHelper.setPivotX(view, view.getWidth());
					ViewHelper.setPivotY(view, view.getHeight() / 2);
					ViewPropertyAnimator mViewPropertyAnimator = ViewPropertyAnimator
							.animate(view);
					mViewPropertyAnimator.setDuration(
							DummyContent.ANIMATION_DURATION).rotation(0);

				} else {
					ViewHelper.setPivotX(view, view.getWidth());
					ViewHelper.setPivotY(view, view.getHeight() / 2);
					ViewPropertyAnimator mViewPropertyAnimator = ViewPropertyAnimator
							.animate(view);
					mViewPropertyAnimator.setDuration(
							DummyContent.ANIMATION_DURATION).rotation(90);
				}
				is90 = !is90;

				break;
			case DummyContent.ID_KITKAT_TRANSITIONS:

				Toast.makeText(getActivity(), "The view is no ViewGroup",
						Toast.LENGTH_SHORT).show();

				break;
			}
		}
	}

	public void showDrawView1(final View view) {
		if (view instanceof DrawView) {
			if (mItem != null) {
				int type = Integer.valueOf(mItem.id);
				switch (type) {
				case DummyContent.ID_OLD_ANIMATIONS:
					Toast.makeText(getActivity(),
							"The animation is not for View Animation",
							Toast.LENGTH_SHORT).show();

					break;

				case DummyContent.ID_PROPERTY_ANIMATIONS:

					android.animation.ObjectAnimator mObjectAnimator = android.animation.ObjectAnimator
							.ofObject(
									view,
									"color",
									new android.animation.TypeEvaluator<Integer>() {

										@Override
										public Integer evaluate(float fraction,
												Integer startValue,
												Integer endValue) {

											int startInt = (Integer) startValue;
											int startA = (startInt >> 24) & 0xff;
											int startR = (startInt >> 16) & 0xff;
											int startG = (startInt >> 8) & 0xff;
											int startB = startInt & 0xff;

											int endInt = (Integer) endValue;
											int endA = (endInt >> 24) & 0xff;
											int endR = (endInt >> 16) & 0xff;
											int endG = (endInt >> 8) & 0xff;
											int endB = endInt & 0xff;

											return (int) ((startA + (int) (fraction * (endA - startA))) << 24)
													| (int) ((startR + (int) (fraction * (endR - startR))) << 16)
													| (int) ((startG + (int) (fraction * (endG - startG))) << 8)
													| (int) ((startB + (int) (fraction * (endB - startB))));
										}
									},
									getResources().getColor(
											R.color.detail_drawview_bg),
									Color.WHITE,
									Color.GREEN,
									Color.BLUE,
									getResources().getColor(
											R.color.detail_drawview_bg));

					mObjectAnimator
							.setDuration(DummyContent.ANIMATION_DURATION * 2);

					mObjectAnimator.start();

					break;

				case DummyContent.ID_PROPERTY_ANIMATIONS_FOR_V4:

					ObjectAnimator mObjectAnimatorV4 = ObjectAnimator
							.ofObject(
									view,
									"color",
									new com.nineoldandroids.animation.TypeEvaluator<Integer>() {

										@Override
										public Integer evaluate(float fraction,
												Integer startValue,
												Integer endValue) {

											int startInt = (Integer) startValue;
											int startA = (startInt >> 24) & 0xff;
											int startR = (startInt >> 16) & 0xff;
											int startG = (startInt >> 8) & 0xff;
											int startB = startInt & 0xff;

											int endInt = (Integer) endValue;
											int endA = (endInt >> 24) & 0xff;
											int endR = (endInt >> 16) & 0xff;
											int endG = (endInt >> 8) & 0xff;
											int endB = endInt & 0xff;

											return (int) ((startA + (int) (fraction * (endA - startA))) << 24)
													| (int) ((startR + (int) (fraction * (endR - startR))) << 16)
													| (int) ((startG + (int) (fraction * (endG - startG))) << 8)
													| (int) ((startB + (int) (fraction * (endB - startB))));
										}
									},
									getResources().getColor(
											R.color.detail_drawview_bg),
									Color.WHITE,
									Color.GREEN,
									Color.BLUE,
									getResources().getColor(
											R.color.detail_drawview_bg));
					mObjectAnimatorV4
							.setDuration(DummyContent.ANIMATION_DURATION * 2);
					mObjectAnimatorV4.start();
					break;

				case DummyContent.ID_KITKAT_TRANSITIONS:

					Toast.makeText(getActivity(), "The view is no ViewGroup",
							Toast.LENGTH_SHORT).show();

					break;
				}
			}
		}
	}

	public void showMoveTogether(final View view) {
		if (mItem != null) {
			int type = Integer.valueOf(mItem.id);
			switch (type) {
			case DummyContent.ID_OLD_ANIMATIONS:

				View child = view.findViewById(R.id.image_uranus);
				TranslateAnimation mTranslateAnimation = new TranslateAnimation(
						0, view.getWidth() - child.getWidth(), 0,
						view.getHeight() - child.getHeight());
				mTranslateAnimation
						.setDuration(DummyContent.ANIMATION_DURATION);

				AlphaAnimation mAlphaAnimation = new AlphaAnimation(1, 0);
				mAlphaAnimation.setDuration(DummyContent.ANIMATION_DURATION);

				AnimationSet mAnimationSet = new AnimationSet(true);
				mAnimationSet.addAnimation(mTranslateAnimation);
				mAnimationSet.addAnimation(mAlphaAnimation);

				child.startAnimation(mAnimationSet);

				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS: {
				final View child2 = view.findViewById(R.id.image_uranus);
				child2.animate()
						.setDuration(DummyContent.ANIMATION_DURATION)
						.alpha(0)
						.xBy(view.getWidth() - child2.getWidth())
						.yBy(view.getHeight() - child2.getHeight())
						.setListener(
								new android.animation.Animator.AnimatorListener() {

									@Override
									public void onAnimationStart(
											android.animation.Animator animation) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onAnimationRepeat(
											android.animation.Animator animation) {
										// TODO Auto-generated method stub

									}

									@Override
									public void onAnimationEnd(
											android.animation.Animator animation) {
										ViewHelper.setX(child2, 0);
										ViewHelper.setY(child2, 0);
										ViewHelper.setAlpha(child2, 1);
									}

									@Override
									public void onAnimationCancel(
											android.animation.Animator animation) {
										// TODO Auto-generated method stub

									}
								});
			}
				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS_FOR_V4:

				final View child2 = view.findViewById(R.id.image_uranus);
				ViewPropertyAnimator.animate(child2)
						.setDuration(DummyContent.ANIMATION_DURATION).alpha(0)
						.xBy(view.getWidth() - child2.getWidth())
						.yBy(view.getHeight() - child2.getHeight())
						.setListener(new Animator.AnimatorListener() {

							@Override
							public void onAnimationStart(Animator animation) {
								// TODO Auto-generated method stub

							}

							@Override
							public void onAnimationRepeat(Animator animation) {
								// TODO Auto-generated method stub

							}

							@Override
							public void onAnimationEnd(Animator animation) {
								// TODO Auto-generated method stub
								ViewHelper.setX(child2, 0);
								ViewHelper.setY(child2, 0);
								ViewHelper.setAlpha(child2, 1);
							}

							@Override
							public void onAnimationCancel(Animator animation) {
								// TODO Auto-generated method stub

							}
						});
				break;

			case DummyContent.ID_KITKAT_TRANSITIONS:
				Toast.makeText(getActivity(), "No use!", Toast.LENGTH_SHORT)
						.show();
				break;
			}
		}
	}

	TimeAnimator mTimeAnimator2;
	android.animation.TimeAnimator mTimeAnimator;

	public void showTimeAnimator(final View view) {
		if (mItem != null) {
			int type = Integer.valueOf(mItem.id);
			switch (type) {
			case DummyContent.ID_OLD_ANIMATIONS:
				Toast.makeText(getActivity(),
						"The animation is not for View Animation",
						Toast.LENGTH_SHORT).show();
				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS:

				if (!isMoveStart) {
					TimeDrawView mTimeDrawView = (TimeDrawView) view
							.findViewById(1204);

					mTimeAnimator = new android.animation.TimeAnimator();
					mTimeAnimator.setTimeListener(mTimeDrawView);
					mTimeAnimator.start();
					isMoveStart = true;
				} else {
					isMoveStart = false;
					mTimeAnimator.cancel();
				}

				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS_FOR_V4:

				if (!isMoveStart) {
					TimeDrawViewV4 mTimeDrawView2 = (TimeDrawViewV4) view
							.findViewById(1204);

					mTimeAnimator2 = new TimeAnimator();
					mTimeAnimator2.setTimeListener(mTimeDrawView2);
					mTimeAnimator2.start();
					isMoveStart = true;

				} else {
					isMoveStart = false;
					mTimeAnimator2.cancel();
				}
				break;

			case DummyContent.ID_KITKAT_TRANSITIONS:
				Toast.makeText(getActivity(), "No use!", Toast.LENGTH_SHORT)
						.show();
				break;
			}
		}
	}

	public void showComplicatedAnim1(final View view) {
		if (mItem != null) {
			int type = Integer.valueOf(mItem.id);
			switch (type) {
			case DummyContent.ID_OLD_ANIMATIONS:

				Toast.makeText(getActivity(), "I can't do that!",
						Toast.LENGTH_SHORT).show();

				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS:

				if (!isCompAnimStart) {
					view.animate()
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.rotationY(360).scaleX(2).scaleY(2).rotationX(360)
							.withStartAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(),
											"Anim1 Start", Toast.LENGTH_SHORT)
											.show();

								}
							}).withEndAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(), "Anim1 End",
											Toast.LENGTH_SHORT).show();

								}
							});
					isCompAnimStart = true;
				} else {
					view.animate()
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.rotationY(0).scaleX(1).scaleY(1).rotationX(0)
							.withStartAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(),
											"Anim1 Start", Toast.LENGTH_SHORT)
											.show();

								}
							}).withEndAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(), "Anim1 End",
											Toast.LENGTH_SHORT).show();

								}
							});
					isCompAnimStart = false;
				}
				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS_FOR_V4:

				if (!isCompAnimStart) {
					ViewPropertyAnimator.animate(view)
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.rotationY(360).scaleX(2).scaleY(2).rotationX(360);
					isCompAnimStart = true;
				} else {
					ViewPropertyAnimator.animate(view)
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.rotationY(0).scaleX(1).scaleY(1).rotationX(0);
					isCompAnimStart = false;
				}
				break;

			case DummyContent.ID_KITKAT_TRANSITIONS:
				Toast.makeText(getActivity(), "No use!", Toast.LENGTH_SHORT)
						.show();
				break;
			}
		}
	}

	public void showComplicatedAnim2(final View view) {
		if (mItem != null) {
			int type = Integer.valueOf(mItem.id);
			switch (type) {
			case DummyContent.ID_OLD_ANIMATIONS:

				Toast.makeText(getActivity(), "I can't do that!",
						Toast.LENGTH_SHORT).show();

				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS:

				if (!isCompAnim2Start) {
					view.setPivotX(view.getWidth());
					view.setPivotY(view.getHeight());
					view.animate()
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.setInterpolator(new DecelerateInterpolator())
							.rotationY(1440).scaleX(2).scaleY(2)
							.withStartAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(),
											"Anim2 Start", Toast.LENGTH_SHORT)
											.show();

								}
							}).withEndAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(), "Anim2 End",
											Toast.LENGTH_SHORT).show();

								}
							});
					isCompAnim2Start = true;
				} else {
					view.setPivotX(view.getWidth());
					view.setPivotY(view.getHeight());
					view.animate()
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.setInterpolator(new DecelerateInterpolator())
							.rotationY(0).scaleX(1).scaleY(1)
							.withStartAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(),
											"Anim2 Start", Toast.LENGTH_SHORT)
											.show();

								}
							}).withEndAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(), "Anim2 End",
											Toast.LENGTH_SHORT).show();

								}
							});
					isCompAnim2Start = false;
				}
				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS_FOR_V4:

				if (!isCompAnim2Start) {
					ViewHelper.setPivotX(view, view.getWidth());
					ViewHelper.setPivotY(view, view.getHeight());
					ViewPropertyAnimator.animate(view)
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.setInterpolator(new DecelerateInterpolator())
							.rotationY(1440).scaleX(2).scaleY(2);
					isCompAnim2Start = true;
				} else {
					ViewHelper.setPivotX(view, view.getWidth());
					ViewHelper.setPivotY(view, view.getHeight());
					ViewPropertyAnimator.animate(view)
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.setInterpolator(new DecelerateInterpolator())
							.rotationY(0).scaleX(1).scaleY(1);
					isCompAnim2Start = false;
				}
				break;

			case DummyContent.ID_KITKAT_TRANSITIONS:
				Toast.makeText(getActivity(), "No use!", Toast.LENGTH_SHORT)
						.show();
				break;
			}
		}
	}

	public void showComplicatedAnim3(final View view) {
		if (mItem != null) {
			int type = Integer.valueOf(mItem.id);
			switch (type) {
			case DummyContent.ID_OLD_ANIMATIONS:

				Toast.makeText(getActivity(), "I can't do that!",
						Toast.LENGTH_SHORT).show();

				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS:

				if (!isCompAnim3Start) {
					view.setPivotX(0);
					view.setPivotY(view.getHeight());
					view.animate()
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.setInterpolator(new DecelerateInterpolator())
							.rotationX(1440).scaleX(2).scaleY(2)
							.withStartAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(),
											"Anim3 Start", Toast.LENGTH_SHORT)
											.show();

								}
							}).withEndAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(), "Anim3 End",
											Toast.LENGTH_SHORT).show();

								}
							});
					isCompAnim3Start = true;
				} else {
					view.setPivotX(0);
					view.setPivotY(view.getHeight());
					view.animate()
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.setInterpolator(new DecelerateInterpolator())
							.rotationX(0).scaleX(1).scaleY(1)
							.withStartAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(),
											"Anim3 Start", Toast.LENGTH_SHORT)
											.show();

								}
							}).withEndAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(), "Anim3 End",
											Toast.LENGTH_SHORT).show();

								}
							});
					isCompAnim3Start = false;
				}
				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS_FOR_V4:

				if (!isCompAnim3Start) {
					ViewHelper.setPivotX(view, 0);
					ViewHelper.setPivotY(view, view.getHeight());
					ViewPropertyAnimator.animate(view)
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.setInterpolator(new DecelerateInterpolator())
							.rotationX(1440).scaleX(2).scaleY(2);
					isCompAnim3Start = true;
				} else {
					ViewHelper.setPivotX(view, 0);
					ViewHelper.setPivotY(view, view.getHeight());
					ViewPropertyAnimator.animate(view)
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.setInterpolator(new DecelerateInterpolator())
							.rotationX(0).scaleX(1).scaleY(1);
					isCompAnim3Start = false;
				}
				break;

			case DummyContent.ID_KITKAT_TRANSITIONS:
				Toast.makeText(getActivity(), "No use!", Toast.LENGTH_SHORT)
						.show();
				break;
			}
		}
	}

	public void showComplicatedAnim4(final View view) {
		if (mItem != null) {
			int type = Integer.valueOf(mItem.id);
			switch (type) {
			case DummyContent.ID_OLD_ANIMATIONS:

				Toast.makeText(getActivity(), "I can't do that!",
						Toast.LENGTH_SHORT).show();

				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS:

				if (!isCompAnim4Start) {
					view.setPivotX(view.getWidth());
					view.setPivotY(view.getHeight());
					view.animate()
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.setInterpolator(new DecelerateInterpolator())
							.alpha(0.3f).scaleX(2).scaleY(2)
							.withStartAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(),
											"Anim4 Start", Toast.LENGTH_SHORT)
											.show();

								}
							}).withEndAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(), "Anim4 End",
											Toast.LENGTH_SHORT).show();

								}
							});
					isCompAnim4Start = true;
				} else {
					view.setPivotX(view.getWidth());
					view.setPivotY(view.getHeight());

					view.animate()
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.setInterpolator(new DecelerateInterpolator())
							.alpha(1).scaleX(1).scaleY(1)
							.withStartAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(),
											"Anim4 Start", Toast.LENGTH_SHORT)
											.show();

								}
							}).withEndAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(), "Anim4 End",
											Toast.LENGTH_SHORT).show();

								}
							});
					isCompAnim4Start = false;
				}
				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS_FOR_V4:

				if (!isCompAnim4Start) {
					ViewHelper.setPivotX(view, view.getWidth());
					ViewHelper.setPivotY(view, view.getHeight());
					ViewPropertyAnimator.animate(view)
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.setInterpolator(new DecelerateInterpolator())
							.alpha(0.3f).scaleX(2).scaleY(2);
					isCompAnim4Start = true;
				} else {
					ViewHelper.setPivotX(view, view.getWidth());
					ViewHelper.setPivotY(view, view.getHeight());
					ViewPropertyAnimator.animate(view)
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.setInterpolator(new DecelerateInterpolator())
							.alpha(1).scaleX(1).scaleY(1);
					isCompAnim4Start = false;
				}
				break;

			case DummyContent.ID_KITKAT_TRANSITIONS:
				Toast.makeText(getActivity(), "No use!", Toast.LENGTH_SHORT)
						.show();
				break;
			}
		}
	}

	public void showComplicatedAnim5(final View view) {
		if (mItem != null) {
			int type = Integer.valueOf(mItem.id);
			switch (type) {
			case DummyContent.ID_OLD_ANIMATIONS:

				Toast.makeText(getActivity(), "I can't do that!",
						Toast.LENGTH_SHORT).show();

				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS:

				if (!isCompAnim5Start) {
					int maxX = imageArea.getWidth() - view.getWidth();
					view.animate()
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.setInterpolator(new BounceInterpolator()).x(maxX)
							.withStartAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(),
											"Anim5 Start", Toast.LENGTH_SHORT)
											.show();

								}
							}).withEndAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(), "Anim5 End",
											Toast.LENGTH_SHORT).show();

								}
							});
					isCompAnim5Start = true;
				} else {
					view.animate()
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.setInterpolator(new BounceInterpolator()).x(0)
							.withStartAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(),
											"Anim5 Start", Toast.LENGTH_SHORT)
											.show();

								}
							}).withEndAction(new Runnable() {

								@Override
								public void run() {

									Toast.makeText(getActivity(), "Anim5 End",
											Toast.LENGTH_SHORT).show();

								}
							});
					isCompAnim5Start = false;
				}
				break;

			case DummyContent.ID_PROPERTY_ANIMATIONS_FOR_V4:

				if (!isCompAnim5Start) {
					int maxX = imageArea.getWidth() - view.getWidth();
					ViewPropertyAnimator.animate(view)
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.setInterpolator(new BounceInterpolator()).x(maxX);
					isCompAnim5Start = true;
				} else {
					ViewPropertyAnimator.animate(view)
							.setDuration(DummyContent.ANIMATION_DURATION * 2)
							.setInterpolator(new BounceInterpolator()).x(0);
					isCompAnim5Start = false;

				}
				break;

			case DummyContent.ID_KITKAT_TRANSITIONS:
				Toast.makeText(getActivity(), "No use!", Toast.LENGTH_SHORT)
						.show();
				break;
			}
		}
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.animation_detail:
			showAlphaAnimation(v);
			break;
		case R.id.button_for_rotate:
			showRotationSequence(v);
			break;
		case R.id.image_area:
			showImageAreaChange(v);
			break;
		case R.id.button_for_rotate_angle:
			showRotation90(v);
			break;
		case R.id.drawview1:
			showDrawView1(v);
			break;
		case R.id.move_area2:
			showMoveTogether(v);
			break;
		case R.id.anim_area:
			showTimeAnimator(v);
			break;
		case R.id.btn_anim1:
			showComplicatedAnim1(v);
			break;
		case R.id.btn_anim2:
			showComplicatedAnim2(v);
			break;
		case R.id.btn_anim3:
			showComplicatedAnim3(v);
			break;
		case R.id.btn_anim4:
			showComplicatedAnim4(v);
			break;
		case R.id.btn_anim5:
			showComplicatedAnim5(v);
			break;
		case R.id.btn_startAnim:
			showValueAnimation();
			break;  
		}

	}
	 
	
	protected void showValueAnimation()
	{
		if(mItem != null)
		{
			int type = Integer.valueOf(mItem.id);
			switch(type)
			{
			case DummyContent.ID_PROPERTY_ANIMATIONS:
				
				value_object.animate().translationX(value_area.getWidth() - value_object.getWidth()).setDuration(2000).setInterpolator(interpolators_[index]).setListener(new android.animation.Animator.AnimatorListener() {

					@Override
					public void onAnimationStart(
							android.animation.Animator animation) { 
						
					}

					@Override
					public void onAnimationEnd(
							android.animation.Animator animation) { 
						value_object.setX(0);
					}

					@Override
					public void onAnimationCancel(
							android.animation.Animator animation) {
						value_object.setX(0);
					}

					@Override
					public void onAnimationRepeat(
							android.animation.Animator animation) { 
						
					} 
				});
				drawValueAnimator.setmInterpolator(interpolators_[index]);
				drawValueAnimator.startAnimation();
				break;
				
			case DummyContent.ID_PROPERTY_ANIMATIONS_FOR_V4:
				ViewPropertyAnimator.animate(value_object).translationX(value_area.getWidth() - value_object.getWidth()).setDuration(2000).setInterpolator(interpolators_[index]).setListener(new AnimatorListener() {
					
					@Override
					public void onAnimationStart(Animator arg0) { 
						
					}
					
					@Override
					public void onAnimationRepeat(Animator arg0) { 
						
					}
					
					@Override
					public void onAnimationEnd(Animator arg0) {
						ViewHelper.setX(value_object, 0);
					}
					
					@Override
					public void onAnimationCancel(Animator arg0) {
						ViewHelper.setX(value_object, 0);
					}
				});
				drawValueAnimatorV4.setmInterpolator(interpolators_[index]);
				drawValueAnimatorV4.startAnimation();	
				break;
			default:
				Toast.makeText(getActivity(), "Not show in this type!", Toast.LENGTH_SHORT)
				.show();
				break;
			}
		}
		
		
	}
	
	int index = 0;
	
	OnItemSelectedListener mInterpolatorSelectedListener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent,
				View view, int position, long id) { 
			    index = position; 
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}
	};
}
