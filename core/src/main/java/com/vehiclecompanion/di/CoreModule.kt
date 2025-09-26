package com.happywebsocketbirthday.di

import com.happywebsocketbirthday.events.EventBus
import com.happywebsocketbirthday.events.IEventBus
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CoreModule {

    @Binds
    @Singleton
    fun bindEventBus(eventBus: EventBus): IEventBus

    companion object {
        @Provides
        @Named("io")
        fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

        @Provides
        @Named("main")
        fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

        @Provides
        @Named("default")
        fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

        @Provides
        @Named("unconfined")
        fun provideUnconfinedDispatcher(): CoroutineDispatcher = Dispatchers.Unconfined

        @Provides
        @Singleton
        @Named("immediate")
        fun provideImmediateDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate

        @Provides
        @Singleton
        @Named("supervisor")
        fun provideDefaultCoroutineScope(
            @Named("default") dispatcher: CoroutineDispatcher
        ): CoroutineScope {
            val exceptionHandler = CoroutineExceptionHandler { _, exception -> }
            return CoroutineScope(SupervisorJob() + dispatcher + exceptionHandler)
        }

        @Provides
        fun provideChildScope(@Named("supervisor") supervisorScope: CoroutineScope): CoroutineScope {
            return CoroutineScope(supervisorScope.coroutineContext + Job())
        }
    }
}
