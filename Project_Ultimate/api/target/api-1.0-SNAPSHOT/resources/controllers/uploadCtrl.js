<div class = "container3">
    <div ng-controller = "uploadCtrl">
        <textarea id="styled" name="data" ng-model="data" cols="40" rows="5"> </textarea>
        <button type = "submit" name = "Upload" value="Upload" id= "submit" class="btn btn-success" ng-click="submit()" class="button button1">Upload</button>
        <style>
            .button1 {
            position: relative;
            top: 191px;
            left: 400px;
            right: -400px;
            bottom: -120px;
            background-color: #4CAF50; /* Green */
            color: white;
            padding: 16px 32px;
            font-size: 16px;
            margin: 4px 2px;
        }
        </style>

    </div>
</div>