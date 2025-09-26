package com.vehiclecompanion.feature;

import com.vehiclecompanion.base.BaseViewModel_MembersInjector;
import com.vehiclecompanion.events.IEventBus;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class FavoritesViewModel_MembersInjector implements MembersInjector<FavoritesViewModel> {
  private final Provider<IEventBus> eventBusProvider;

  public FavoritesViewModel_MembersInjector(Provider<IEventBus> eventBusProvider) {
    this.eventBusProvider = eventBusProvider;
  }

  public static MembersInjector<FavoritesViewModel> create(Provider<IEventBus> eventBusProvider) {
    return new FavoritesViewModel_MembersInjector(eventBusProvider);
  }

  @Override
  public void injectMembers(FavoritesViewModel instance) {
    BaseViewModel_MembersInjector.injectEventBus(instance, eventBusProvider.get());
  }
}
