package io.appium.java_client.service.local.flags;

/**
* Here is the list of iOS specific server arguments.
* All flags are optional, but some are required in conjunction with certain others.
* The full list is available here: {@link http://appium.io/slate/en/master/?ruby#appium-server-arguments}
* iOS specific arguments are marked by (IOS-only)
*/
public enum IOSServerFlag implements ServerArgument{
    /**
     * the relative path of the dir where Localizable.strings file
     * resides<br/>
     * Default: en.lproj<br/>
     * Sample:<br/>
     * --localizable-strings-dir en.lproj
     */
    LOCALIZABLE_STRING_PATH("--localizable-strings-dir"),
    /**
     * absolute path to compiled .ipa file
     * Sample:<br/>
     * --ipa /abs/path/to/my.ipa
     */
    IPA_ABSOLUTE_PATH("--ipa"),
    /**
     * How many times to retry launching Instruments before saying it
     * crashed or timed out<br/>
     * Sample:<br/>
     * --backend-retries 3
     */
    BACK_END_RETRIES("--backend-retries"),
    /**
     *  how long in ms to wait for Instruments to launch<br/>
     *  Default: 90000
     */
    LAUNCH_TIMEOUT("--launch-timeout"),
    /**
     * IOS has a weird built-in unavoidable delay. We patch this in
     * appium. If you do not want it patched, pass in this flag.<br/>
     * Default: false
     */
    USE_NATIVE_INSTRUMENTS("--native-instruments-lib"),
    /**
     * Use the safari app<br/>
     * Default: false
     */
    SAFARI("--safari"),
    /**
     * use the default simulator that instruments launches
     * on its own<br/>
     * Default: false
     *
     */
    DEFAULT_DEVICE("--default-device"),
    /**
     * Use the iPhone Simulator no matter what the app wants<br/>
     * Default: false
     */
    FORCE_IPHONE_SIMULATOR("--force-iphone"),
    /**
     * Use the iPad Simulator no matter what the app wants<br/>
     * Default: false
     */
    FORCE_IPAD_SIMULATOR("--force-ipad"),
    /**
     * Calendar format for the iOS simulator<br/>
     * Default: null<br/>
     * Sample:<br/>
     * --calendar-format gregorian
     */
    CALENDAR_FORMAT("--calendar-format"),
    /**
     * use LANDSCAPE or PORTRAIT to initialize all requests to this
     * orientation<br/>
     * Sample:<br/>
     * --orientation LANDSCAPE
     */
    ORIENTATION("--orientation"),
    /**
     * .tracetemplate file to use with Instruments<br/>
     * Sample:<br/>
     * --tracetemplate /Users/me/Automation.tracetemplate
     */
    TRACE_TEMPLATE_FILE_PATH("--tracetemplate"),
    /**
     * custom path to the instruments commandline tool<br/>
     * Sample:<br/>
     * --instruments /path/to/instruments
     */
    CUSTOM_INSTRUMENTS_PATH("--instruments"),
    /**
     * if set, the iOS simulator log will be written to the console<br/>
     * Default: false
     */
    SHOW_SIMULATOR_LOG("--show-sim-log"),
    /**
     * if set, the iOS system log will be written to the console<br/>
     * Default: false
     */
    SHOW_IOS_LOG("--show-ios-log"),
    /**
     * Whether to keep keychains (Library/Keychains) when reset app
     * between sessions<br/>
     * Default: false
     */
    KEEP_KEYCHAINS("--keep-keychains"),
    /**
     * Xcode 6 has a bug on some platforms where a certain simulator can only be
     * launched without error if all other simulator devices are first deleted.
     * This option causes Appium to delete all devices other than the one being
     * used by Appium. Note that this is a permanent deletion, and you are
     * responsible for using simctl or xcode to manage the categories of devices
     * used with Appium<br/>.
     * Default: false
     */
    ISOLATE_SIM_DEVICE("--isolate-sim-device"),
    /**
     * Absolute path to directory Appium use to save ios instruments traces,
     * defaults to /appium-instruments<br/>
     * Default: null
     */
    TRACE_DIRECTORY_ABSOLUTE_PATH("--trace-dir");

    private final String arg;

    private IOSServerFlag(String arg) {
        this.arg = arg;
    }

    @Override
    public String getArgument() {
        return arg;
    }
}
