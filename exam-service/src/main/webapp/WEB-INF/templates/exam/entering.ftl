<@master template="layout/master">
<script type="text/javascript">
    $(document).ready(function () {
        $("#type").change(function () {
            nameChangeByType(this);
        });
    });
</script>
<div class="row full page-title">
    <form class="custom" id="enteringForm" action="<@url value='/exam/entering'/>" method="post">

        <div class="row collapse">
            <div class="large-3 left columns">
                <div class="small-7 columns text-right">
                    <h4>Select Condition:</h4>
                </div>
                <div class="small-4 columns">
                    <div id="errInfo" class="errorBox"></div>
                </div>

            </div>
            <div class="large-2 left columns">
                <div class="small-4 columns text-right">
                    <label style="margin-top:10px;">Type:</label>
                </div>
                <div class="small-7 columns">
                    <select id="type" name="type">
                        <#if types??>
                            <#list types as type>
                                <option value=${type}>${type}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
            </div>

            <div class="large-2 left columns">
                <div class="small-4 columns text-right">
                    <label style="margin-top:10px;">Level:</label>
                </div>
                <div class="small-7 columns">
                    <select id="level" name="level">
                        <#if levels??>
                            <#list levels as level>
                                <option value=${level}>${level}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
            </div>

            <div class="large-2 left columns">
                <div class="small-4 columns text-right">
                    <label style="margin-top:10px;">Section:</label>
                </div>
                <div class="small-7 columns">
                    <select id="section" name="section">
                        <#if sections??>
                            <#list sections as section>
                                <option value=${section}>${section}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
            </div>

            <div class="large-3 left columns" style="padding-left: 55px;">
                <div class="small-3 columns">
                    <a class="small radius button" id="button" onclick="enter()" href="javascript:void(0)">Enter</a>
                </div>
                <div class="loadingDiv displayNone" id="loadingLogo"></div>
            </div>
        </div>

        <div class="row collapse">
            <fieldset>
                <label style="margin-top:10px;">Name:</label><br/>

                <textarea rows="2" name="name" id="name" cols="20"></textarea>

                <div id="select">
                    <label style="margin-top:10px;">A:</label><br/>
                    <input type="text" name="question1"><br/>
                    <label style="margin-top:10px;">B:</label><br/>
                    <input type="text" name="question2"><br/>
                    <label style="margin-top:10px;">C:</label><br/>
                    <input type="text" name="question3"><br/>
                    <label style="margin-top:10px;">D:</label><br/>
                    <input type="text" name="question4"><br/>
                </div>

                <label style="margin-top:10px;">Answer:</label><br/>
                <textarea rows="2" name="answer" id="answer" cols="20"></textarea>
            </fieldset>
        </div>

    </form>
</div>
<script type="text/javascript">
    function nameChangeByType(object) {
        $("#select").hide();

        var type = $(object).val();
        if ("Select" == type) {
            $("#select").show();
        }
    }

    function enter() {
        $("#loadingLogo").css("display", "inline-block");
        $("#button").attr('disabled', true);
        $("#enteringForm").ajaxSubmit({callback: function (result) {
            alert(result.errMsg);
            $('#loadingLogo').css("display", "none");
            $("#button").attr("disabled", false);
        }, validate: false});
    }
</script>
</@master>