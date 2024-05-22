package org.thoughtcrime.securesms.keyvalue;

import android.content.Context;

import androidx.annotation.NonNull;

import java.util.Collections;
import java.util.List;

public final class OnboardingValues extends SignalStoreValues {

  private static final String SHOW_STORIES        = "onboarding.stories_molly";
  private static final String SHOW_INVITE_FRIENDS = "onboarding.invite_friends";
  private static final String SHOW_APPEARANCE     = "onboarding.appearance";
  private static final String SHOW_ADD_PHOTO      = "onboarding.add_photo";

  OnboardingValues(@NonNull KeyValueStore store) {
    super(store);
  }

  @Override
  void onFirstEverAppLaunch() {
    putBoolean(SHOW_STORIES, true);
    putBoolean(SHOW_INVITE_FRIENDS, true);
    putBoolean(SHOW_APPEARANCE, true);
    putBoolean(SHOW_ADD_PHOTO, true);
  }

  @Override
  @NonNull List<String> getKeysToIncludeInBackup() {
    return Collections.emptyList();
  }

  public void clearAll() {
    setShowStories(false);
    setShowInviteFriends(false);
    setShowAppearance(false);
    setShowAddPhoto(false);
  }

  public boolean hasOnboarding(@NonNull Context context) {
    return shouldShowStories()       ||
           shouldShowInviteFriends() ||
           shouldShowAppearance()    ||
           shouldShowAddPhoto();
  }

  public void setShowStories(boolean value) {
    putBoolean(SHOW_STORIES, value);
  }

  public boolean shouldShowStories(){
    if (SignalStore.settings().getParentalLockEnabled()) return false;
    return getBoolean(SHOW_STORIES, false);
  }

  public void setShowInviteFriends(boolean value) {
    putBoolean(SHOW_INVITE_FRIENDS, value);
  }

  public boolean shouldShowInviteFriends() {
    if (SignalStore.settings().getParentalLockEnabled()) return false;
    return getBoolean(SHOW_INVITE_FRIENDS, false);
  }

  public void setShowAppearance(boolean value) {
    putBoolean(SHOW_APPEARANCE, value);
  }

  public boolean shouldShowAppearance() {
    return getBoolean(SHOW_APPEARANCE, false);
  }

  public void setShowAddPhoto(boolean value) {
    putBoolean(SHOW_ADD_PHOTO, value);
  }

  public boolean shouldShowAddPhoto() {
    return getBoolean(SHOW_ADD_PHOTO, false);
  }
}
