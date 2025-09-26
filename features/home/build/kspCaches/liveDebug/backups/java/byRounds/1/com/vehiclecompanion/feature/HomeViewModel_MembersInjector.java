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
public final class HomeViewModel_MembersInjector implements MembersInjector<HomeViewModel> {
  private final Provider<IEventBus> eventBusProvider;

  public HomeViewModel_MembersInjector(Provider<IEventBus> eventBusProvider) {
    this.eventBusProvider = eventBusProvider;
  }

  public static MembersInjector<HomeViewModel> create(Provider<IEventBus> eventBusProvider) {
    return new HomeViewModel_MembersInjector(eventBusProvider);
  }

  @Override
  public void injectMembers(HomeViewModel instance) {
    BaseViewModel_MembersInjector.injectEventBus(instance, eventBusProvider.get());
  }
}
