// Generated by view binder compiler. Do not edit!
package com.example.hw2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.hw2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemCardDetailBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final TextView textItemCardDetailSubject;

  @NonNull
  public final TextView textItemCardDetailValue;

  private ItemCardDetailBinding(@NonNull FrameLayout rootView,
      @NonNull TextView textItemCardDetailSubject, @NonNull TextView textItemCardDetailValue) {
    this.rootView = rootView;
    this.textItemCardDetailSubject = textItemCardDetailSubject;
    this.textItemCardDetailValue = textItemCardDetailValue;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemCardDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemCardDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_card_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemCardDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.text_item_card_detail_subject;
      TextView textItemCardDetailSubject = ViewBindings.findChildViewById(rootView, id);
      if (textItemCardDetailSubject == null) {
        break missingId;
      }

      id = R.id.text_item_card_detail_value;
      TextView textItemCardDetailValue = ViewBindings.findChildViewById(rootView, id);
      if (textItemCardDetailValue == null) {
        break missingId;
      }

      return new ItemCardDetailBinding((FrameLayout) rootView, textItemCardDetailSubject,
          textItemCardDetailValue);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
