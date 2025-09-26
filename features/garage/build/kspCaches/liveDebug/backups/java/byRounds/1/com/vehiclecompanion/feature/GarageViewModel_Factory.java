package com.vehiclecompanion.feature;

import com.vehiclecompanion.base.BaseViewModel_MembersInjector;
import com.vehiclecompanion.events.IEventBus;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class GarageViewModel_Factory implements Factory<GarageViewModel> {
  private final Provider<IEventBus> eventBusProvider;

  private final Provider<IEventBus> eventBusProvider2;

  public GarageViewModel_Factory(Provider<IEventBus> eventBusProvider,
      Provider<IEventBus> eventBusProvider2) {
    this.eventBusProvider = eventBusProvider;
    this.eventBusProvider2 = eventBusProvider2;
  }

  @Override
  public GarageViewModel get() {
    GarageViewModel instance = newInstance(eventBusProvider.get());
    BaseViewModel_MembersInjector.injectEventBus(instance, eventBusProvider2.get());
    return instance;
  }

  public static GarageViewModel_Factory create(Provider<IEventBus> eventBusProvider,
      Provider<IEventBus> eventBusProvider2) {
    return new GarageViewModel_Factory(eventBusProvider, eventBusProvider2);
  }

  public static GarageViewModel newInstance(IEventBus eventBus) {
    return new GarageViewModel(eventBus);
  }
}
