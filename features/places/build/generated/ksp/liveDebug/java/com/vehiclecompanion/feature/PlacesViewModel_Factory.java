package com.vehiclecompanion.feature;

import com.vehiclecompanion.base.BaseViewModel_MembersInjector;
import com.vehiclecompanion.events.IEventBus;
import com.vehiclecompanion.usecase.DiscoverPlacesUseCase;
import com.vehiclecompanion.usecase.GetAllFavoritesUseCase;
import com.vehiclecompanion.usecase.GetFavoritePoiIdsUseCase;
import com.vehiclecompanion.usecase.ToggleFavoritePoiUseCase;
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
public final class PlacesViewModel_Factory implements Factory<PlacesViewModel> {
  private final Provider<IEventBus> eventBusProvider;

  private final Provider<DiscoverPlacesUseCase> discoverPlacesUseCaseProvider;

  private final Provider<GetFavoritePoiIdsUseCase> getFavoritePoiIdsUseCaseProvider;

  private final Provider<GetAllFavoritesUseCase> getAllFavoritesUseCaseProvider;

  private final Provider<ToggleFavoritePoiUseCase> toggleFavoritePoiUseCaseProvider;

  private final Provider<IEventBus> eventBusProvider2;

  public PlacesViewModel_Factory(Provider<IEventBus> eventBusProvider,
      Provider<DiscoverPlacesUseCase> discoverPlacesUseCaseProvider,
      Provider<GetFavoritePoiIdsUseCase> getFavoritePoiIdsUseCaseProvider,
      Provider<GetAllFavoritesUseCase> getAllFavoritesUseCaseProvider,
      Provider<ToggleFavoritePoiUseCase> toggleFavoritePoiUseCaseProvider,
      Provider<IEventBus> eventBusProvider2) {
    this.eventBusProvider = eventBusProvider;
    this.discoverPlacesUseCaseProvider = discoverPlacesUseCaseProvider;
    this.getFavoritePoiIdsUseCaseProvider = getFavoritePoiIdsUseCaseProvider;
    this.getAllFavoritesUseCaseProvider = getAllFavoritesUseCaseProvider;
    this.toggleFavoritePoiUseCaseProvider = toggleFavoritePoiUseCaseProvider;
    this.eventBusProvider2 = eventBusProvider2;
  }

  @Override
  public PlacesViewModel get() {
    PlacesViewModel instance = newInstance(eventBusProvider.get(), discoverPlacesUseCaseProvider.get(), getFavoritePoiIdsUseCaseProvider.get(), getAllFavoritesUseCaseProvider.get(), toggleFavoritePoiUseCaseProvider.get());
    BaseViewModel_MembersInjector.injectEventBus(instance, eventBusProvider2.get());
    return instance;
  }

  public static PlacesViewModel_Factory create(Provider<IEventBus> eventBusProvider,
      Provider<DiscoverPlacesUseCase> discoverPlacesUseCaseProvider,
      Provider<GetFavoritePoiIdsUseCase> getFavoritePoiIdsUseCaseProvider,
      Provider<GetAllFavoritesUseCase> getAllFavoritesUseCaseProvider,
      Provider<ToggleFavoritePoiUseCase> toggleFavoritePoiUseCaseProvider,
      Provider<IEventBus> eventBusProvider2) {
    return new PlacesViewModel_Factory(eventBusProvider, discoverPlacesUseCaseProvider, getFavoritePoiIdsUseCaseProvider, getAllFavoritesUseCaseProvider, toggleFavoritePoiUseCaseProvider, eventBusProvider2);
  }

  public static PlacesViewModel newInstance(IEventBus eventBus,
      DiscoverPlacesUseCase discoverPlacesUseCase,
      GetFavoritePoiIdsUseCase getFavoritePoiIdsUseCase,
      GetAllFavoritesUseCase getAllFavoritesUseCase,
      ToggleFavoritePoiUseCase toggleFavoritePoiUseCase) {
    return new PlacesViewModel(eventBus, discoverPlacesUseCase, getFavoritePoiIdsUseCase, getAllFavoritesUseCase, toggleFavoritePoiUseCase);
  }
}
