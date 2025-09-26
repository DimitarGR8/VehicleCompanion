package com.vehiclecompanion.enums

import com.vehiclecompanion.core.R

enum class DialogTypes(
    val titleRes: Int,
    val subtitleRes: Int,
    var titleString: String? = null,
    var subTitleString: String? = null,
    var buttonTextRes: Int = R.string.close
) {
    SOMETHING_WENT_WRONG(R.string.something_went_wrong_header, R.string.try_again_later_sub_header),
    SERVICE_UNAVAILABLE(R.string.service_unavailable_header, R.string.try_again_later_sub_header),
    CONNECTION_TIMEOUT(
        R.string.connection_timeout_header,
        R.string.could_not_reach_server_sub_header
    ),
    NO_INTERNET(R.string.no_internet_header, R.string.connect_to_internet_sub_header)
}
