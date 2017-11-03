package pl.treksoft.kvision.form


open class Text(type: TEXTINPUTTYPE = TEXTINPUTTYPE.TEXT, value: String? = null,
                label: String? = null, rich: Boolean = false) : AbstractText(label, rich) {

    var type
        get() = input.type
        set(value) {
            input.type = value
        }
    var autocomplete
        get() = input.autocomplete
        set(value) {
            input.autocomplete = value
        }

    final override val input: TextInput = TextInput(type, value).apply { id = idc }

    init {
        this.addInternal(input)
    }
}