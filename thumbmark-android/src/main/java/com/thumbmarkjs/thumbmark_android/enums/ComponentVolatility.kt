package com.thumbmarkjs.thumbmark_android.enums

enum class ComponentVolatility(val value: Int) {
    /**
     * Component is very stable and unlikely to ever change.
     * For example, capture devices are marked as `low` as these are
     * hardware components baked into the device, and are not able to change.
     */
    LOW(0),

    /**
     * Component is somewhat stable and is subject to change with some notice.
     * For example, user accessibility settings are marked as `medium` as it is unlikely that
     * these would change day to day, but it is foreseeable that they may as the users accessibility needs change over time.
     */
    MEDIUM(1),

    /**
     * Component is extremely unstable and values are likely to be extremely fragile.
     * For example, device metrics are marked as `high` as it is very likely that
     * a user will update their device at some point, which would change this value.
     */
    HIGH(2)
}