// Generated by view binder compiler. Do not edit!
package com.example.hw2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.hw2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCardDetailBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final ImageView cardDetailBackIcon;

  @NonNull
  public final TextView cardDetailLocation;

  @NonNull
  public final ImageView cardDetailMainImage;

  @NonNull
  public final TextView cardDetailPrice;

  @NonNull
  public final FrameLayout cardDetailRecyclerLayout;

  @NonNull
  public final FloatingActionButton fabCall;

  @NonNull
  public final FloatingActionButton fabMessage;

  @NonNull
  public final RecyclerView recyclerCardDetail;

  private ActivityCardDetailBinding(@NonNull ScrollView rootView,
      @NonNull ImageView cardDetailBackIcon, @NonNull TextView cardDetailLocation,
      @NonNull ImageView cardDetailMainImage, @NonNull TextView cardDetailPrice,
      @NonNull FrameLayout cardDetailRecyclerLayout, @NonNull FloatingActionButton fabCall,
      @NonNull FloatingActionButton fabMessage, @NonNull RecyclerView recyclerCardDetail) {
    this.rootView = rootView;
    this.cardDetailBackIcon = cardDetailBackIcon;
    this.cardDetailLocation = cardDetailLocation;
    this.cardDetailMainImage = cardDetailMainImage;
    this.cardDetailPrice = cardDetailPrice;
    this.cardDetailRecyclerLayout = cardDetailRecyclerLayout;
    this.fabCall = fabCall;
    this.fabMessage = fabMessage;
    this.recyclerCardDetail = recyclerCardDetail;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCardDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCardDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_card_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCardDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.card_detail_back_icon;
      ImageView cardDetailBackIcon = ViewBindings.findChildViewById(rootView, id);
      if (cardDetailBackIcon == null) {
        break missingId;
      }

      id = R.id.card_detail_location;
      TextView cardDetailLocation = ViewBindings.findChildViewById(rootView, id);
      if (cardDetailLocation == null) {
        break missingId;
      }

      id = R.id.card_detail_main_image;
      ImageView cardDetailMainImage = ViewBindings.findChildViewById(rootView, id);
      if (cardDetailMainImage == null) {
        break missingId;
      }

      id = R.id.card_detail_price;
      TextView cardDetailPrice = ViewBindings.findChildViewById(rootView, id);
      if (cardDetailPrice == null) {
        break missingId;
      }

      id = R.id.card_detail_recycler_layout;
      FrameLayout cardDetailRecyclerLayout = ViewBindings.findChildViewById(rootView, id);
      if (cardDetailRecyclerLayout == null) {
        break missingId;
      }

      id = R.id.fabCall;
      FloatingActionButton fabCall = ViewBindings.findChildViewById(rootView, id);
      if (fabCall == null) {
        break missingId;
      }

      id = R.id.fabMessage;
      FloatingActionButton fabMessage = ViewBindings.findChildViewById(rootView, id);
      if (fabMessage == null) {
        break missingId;
      }

      id = R.id.recyclerCardDetail;
      RecyclerView recyclerCardDetail = ViewBindings.findChildViewById(rootView, id);
      if (recyclerCardDetail == null) {
        break missingId;
      }

      return new ActivityCardDetailBinding((ScrollView) rootView, cardDetailBackIcon,
          cardDetailLocation, cardDetailMainImage, cardDetailPrice, cardDetailRecyclerLayout,
          fabCall, fabMessage, recyclerCardDetail);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
