package com.spartons.paymentappintro.enum

enum class TypeFaceEnum(val value: String) {
    HEADING_TYPEFACE("fonts/RisingStar_Regular.otf"),
    SEMI_TITLE_TYPEFACE("fonts/SourceSansPro-Regular.otf"),
    BUTTON_TEXT("fonts/Ubuntu-M.ttf");

    fun getName() = value
}