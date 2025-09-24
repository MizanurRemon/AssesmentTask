package com.technonext.network.di.qualifier

import com.technonext.network.di.TypeEnum
import javax.inject.Qualifier

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class PublicNetwork(val value: TypeEnum)
